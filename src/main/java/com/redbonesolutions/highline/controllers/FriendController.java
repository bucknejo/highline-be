package com.redbonesolutions.highline.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redbonesolutions.highline.domain.Friend;
import com.redbonesolutions.highline.domain.User;
import com.redbonesolutions.highline.service.FriendService;

@RestController
@RequestMapping("/service/friend")
public class FriendController {

    private final static Logger LOG = LoggerFactory.getLogger(FriendController.class);

    @Autowired
    private FriendService friendService;

    // get all members
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public List<Friend> getFriends(@PathVariable(value="id") int id) {

        LOG.debug(String.format("friend id:%s", id));
        System.out.println(String.format("friend id:%s", id));

        List<Friend> users = friendService.getFriends(id);

        return users;

    }

    // get all friends not already in gruppe
    @RequestMapping(value="/{user_id}/gruppe/{gruppe_id}", method = RequestMethod.GET)
    public List<User> getFriendsNotAlreadyInGruppe(
            @PathVariable(value="user_id") long user_id,
            @PathVariable(value="gruppe_id") long gruppe_id
    ) {

        LOG.debug(String.format("friend id:%s", user_id));
        System.out.println(String.format("friend id:%s", user_id));

        LOG.debug(String.format("gruppe id:%s", gruppe_id));
        System.out.println(String.format("gruppe id:%s", gruppe_id));

        List<User> users = friendService.getFriendsNotInGroup(user_id, gruppe_id);

        return users;

    }

    // get all friends not already in ride
    @RequestMapping(value="/{user_id}/ride/{ride_id}", method = RequestMethod.GET)
    public List<User> getFriendsNotAlreadyInRide(
            @PathVariable(value="user_id") long user_id,
            @PathVariable(value="ride_id") long ride_id
    ) {

        LOG.debug(String.format("friend id:%s", user_id));
        System.out.println(String.format("friend id:%s", user_id));

        LOG.debug(String.format("ride id:%s", ride_id));
        System.out.println(String.format("ride id:%s", ride_id));

        List<User> users = friendService.getFriendsNotInRide(user_id, ride_id);

        return users;

    }



}
