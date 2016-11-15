package com.redbonesolutions.highline.controllers;

import com.redbonesolutions.highline.domain.Test;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/**")
@CrossOrigin(origins = "http://localhost:8090")
public class TestController {

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Test index() {
        return new Test(10, 7);
    }
}