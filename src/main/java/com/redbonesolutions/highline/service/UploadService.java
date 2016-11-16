package com.redbonesolutions.highline.service;

import com.google.common.base.Joiner;
import com.redbonesolutions.highline.domain.Photo;
import com.redbonesolutions.highline.utility.HighlineUtility;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

@Service
public class UploadService {

    private static final int BUFFER_SIZE = 100 * 1024;
    private final static Logger LOG = LoggerFactory.getLogger(UploadService.class);
    private static final int DEPTH_PATH = 5;
    private static final int DEPTH_FILE = 64;

    @Autowired
    private UserService userService;

    @Autowired
    private PhotoService photoService;

    @Value("#{HighlinePropertySplitter.map('${highline.upload.paths}')}")
    private Map<String, String> uploadPaths;

    @Value("${highline.upload.base}")
    private String uploadBase;

    @Value("${server.contextPath}")
    private String contextPath;

    @Value("${highline.server.be}")
    private String resourceServer;

    @Value("${highline.upload.resource}")
    private String uploadResource;

    public boolean saveFile(long user_id, String path_id, String original, MultipartFile file, String name, int chunks, int chunk) {

        boolean saved = true;

        String[] paths = {
                File.separator,
                uploadBase,
                uploadPaths.get(path_id),
                destinationPath(name, DEPTH_PATH)
        };

        File uploadPath = new File(Joiner.on("").join(paths));


        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        File uploadFile = new File(uploadPath, name);

        if (chunk == 0 && uploadFile.exists()) {
            uploadFile.delete();
            uploadFile = new File(uploadPath, name);
        }

        try {
            appendFile(file.getInputStream(), uploadFile);
        } catch (IOException ie) {
            LOG.error(String.format("Exception: %s", ie.getMessage()));
            saved = false;
        }

        // rename to whatever when upload is complete
        if (chunk == (chunks - 1)) {

            String url = uploadFile.getAbsolutePath();
            String relativePath = String.format("%s%s%s%s", resourceServer, contextPath, uploadResource, relativePath(url, path_id));

            LOG.info(String.format("Chunk: %s of %s is complete.", chunk + 1, chunks));
            LOG.info("Upload is complete");

            LOG.info(String.format("url: %s", url));
            LOG.info(String.format("user_id: %s", user_id));
            LOG.info(String.format("relativePath: %s", relativePath));

            userService.updateAvatar(relativePath, user_id);
            photoService.save(photoFactory(relativePath, name, original, user_id));

        } else {
            LOG.info(String.format("Chunk: %s of %s is complete.", chunk + 1, chunks));
        }

        return saved;
    }

    private void appendFile(InputStream in, File destFile) {
        OutputStream out = null;
        try {
            if (destFile.exists()) {
                out = new BufferedOutputStream(new FileOutputStream(destFile, true), BUFFER_SIZE);
            } else {
                out = new BufferedOutputStream(new FileOutputStream(destFile), BUFFER_SIZE);
            }
            in = new BufferedInputStream(in, BUFFER_SIZE);

            int len = 0;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    private String destinationPath(String file, int depth) {
        return File.separator + Joiner.on(File.separator).join(Arrays.copyOfRange(file.split(""), 0, depth));
    }

    private String randomFileName(int depth, String name) {
        return String.format("%s.%s", RandomStringUtils.randomAlphanumeric(depth), FilenameUtils.getExtension(name));
    }

    private String relativePath(String url, String path_id) {
        return File.separator + url.substring(url.indexOf(uploadPaths.get(path_id)));
    }

    private Photo photoFactory(String url, String generated, String original, long user_id) {
        Photo photo = new Photo();

        photo.setDate_created(HighlineUtility.getCurrentDate());
        photo.setLast_updated(HighlineUtility.getLastModified());
        photo.setActive(1);
        photo.setType("USER");
        photo.setType_id(1);
        photo.setUrl(url);
        photo.setAlt("");
        photo.setHeight(0);
        photo.setWidth(0);
        photo.setDescription("");
        photo.setGenerated(generated);
        photo.setOriginal(original);
        photo.setUser_id(user_id);

        return photo;
    }

}
