package com.redbonesolutions.highline.controllers;


import com.redbonesolutions.highline.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/service/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @ResponseBody
    @RequestMapping(value="/plupload", method = RequestMethod.POST)
    public String plupload(
            @RequestParam long user_id,
            @RequestParam String path_id,
            @RequestParam String original,
            @RequestParam MultipartFile file,
            @RequestParam String name,
            @RequestParam(required=false, defaultValue="0") int chunks,
            @RequestParam(required=false, defaultValue="0") int chunk) {

        uploadService.saveFile(user_id, path_id, original, file, name, chunks, chunk);

        return "";

    }


}
