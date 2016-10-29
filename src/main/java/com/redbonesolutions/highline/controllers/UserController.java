package com.redbonesolutions.highline.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redbonesolutions.highline.domain.User;
import com.redbonesolutions.highline.service.UserService;

@RestController
@RequestMapping("/service/user")
@CrossOrigin(origins = "http://localhost:8090")
public class UserController {

    private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // get all users
    @RequestMapping(value="", method = RequestMethod.GET)
    public List<User> getUsers() {

        List<User> users = userService.findAll();

        return users;

    }

    // get one user
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable(value="id") int id) {

        LOG.debug(String.format("id:%s", id));
        System.out.println(String.format("id:%s", id));

        User user = userService.findOne(id);

        return user;

    }

    // post one user (add)
    @RequestMapping(value="", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {

        LOG.debug(String.format("Add User: %s", user.toString()));
        System.out.println(String.format("Add User: %s", user.toString()));

        return userService.add(user);

    }

    // put one user (save)
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public User saveUser(
            @PathVariable(value="id") int id,
            @RequestBody User user
    ) {

        LOG.debug(String.format("id:%s", id));
        System.out.println(String.format("id:%s", id));

        LOG.debug(String.format("Save User: %s", user.toString()));
        System.out.println(String.format("Save User: %s", user.toString()));

        return userService.save(user);

    }

    // delete one user (remove)
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public User removeUser(
            @PathVariable(value="id") int id
    ) {

        LOG.debug(String.format("id:%s", id));
        System.out.println(String.format("id:%s", id));

        User user = userService.findOne(id);

        LOG.debug(String.format("Delete User: %s", user.toString()));
        System.out.println(String.format("Delete User: %s", user.toString()));

        userService.delete(user);

        return user;

    }


}
