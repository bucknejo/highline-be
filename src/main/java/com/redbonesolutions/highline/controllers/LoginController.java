package com.redbonesolutions.highline.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redbonesolutions.highline.domain.User;
import com.redbonesolutions.highline.service.UserService;
import com.redbonesolutions.highline.utility.HighlineLogin;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "http://localhost:8090")
public class LoginController {

    private final static Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private HighlineLogin highlineLogin;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HighlineLogin login(@RequestBody User user) {

        LOG.debug(String.format("Login User: %s", user.getEmail()));
        LOG.debug(String.format("Login Password: %s", user.getPassword()));
        System.out.println(String.format("Login User: %s", user.getEmail()));
        System.out.println(String.format("Login Password: %s", user.getPassword()));

        return userService.authenticate(user.getEmail(), user.getPassword());

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestBody User user) {

        LOG.debug(String.format("Register User: %s", user.getEmail()));
        LOG.debug(String.format("Register Password: %s", user.getPassword()));
        System.out.println(String.format("Register User: %s", user.getEmail()));
        System.out.println(String.format("Register Password: %s", user.getPassword()));

        user = userService.createNewUser(user.getEmail(), user.getPassword());

        return user;
    }

}
