package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.Photo;
import com.redbonesolutions.highline.repository.PhotoRepository;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    public Photo save(Photo p) {
        return photoRepository.save(p);
    }

    public void delete(Photo p) {
        photoRepository.delete(p);
    }

    public Photo findOne(long id) {
        return photoRepository.findOne(id);
    }
}
