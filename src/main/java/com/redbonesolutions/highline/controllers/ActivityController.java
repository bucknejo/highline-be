package com.redbonesolutions.highline.controllers;

import com.redbonesolutions.highline.domain.Activity;
import com.redbonesolutions.highline.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/activity")
@CrossOrigin(origins = "http://localhost:8090")
public class ActivityController {

    private final static Logger LOG = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
    public List<Activity> getAllActivitiesByUser(@PathVariable(value="user_id") long user_id) {

        return activityService.getActivitiesByUserId(user_id);

    }
}
