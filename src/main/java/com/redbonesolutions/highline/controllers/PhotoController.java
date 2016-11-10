package com.redbonesolutions.highline.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redbonesolutions.highline.domain.Photo;
import com.redbonesolutions.highline.service.PhotoService;

@RestController
@RequestMapping("/service/photo")
public class PhotoController {

    private final static Logger LOG = LoggerFactory.getLogger(PhotoController.class);

    @Autowired
    private PhotoService photoService;

    @RequestMapping(value="/get", method = RequestMethod.GET)
    public List<Photo> photos() {

        List<Photo> photos = photoService.findAll();

        return photos;

    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public Photo photo(@PathVariable(value="id") int id) {

        LOG.debug(String.format("id:%s", id));
        System.out.println(String.format("id:%s", id));

        Photo photo = photoService.findOne(id);

        return photo;

    }



}
