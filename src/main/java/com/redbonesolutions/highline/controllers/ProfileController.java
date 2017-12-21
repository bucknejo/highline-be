package com.redbonesolutions.highline.controllers;

import com.redbonesolutions.highline.domain.Profile;
import com.redbonesolutions.highline.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/profile")
public class ProfileController {

    private final static Logger LOG = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Profile> profiles() {
        return profileService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Profile profile(@PathVariable(value = "id") long id) {
        return profileService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Profile add(@RequestBody Profile profile) {
        return profileService.add(profile);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Profile save(@RequestBody Profile profile) {
        return  profileService.save(profile);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Profile update(@RequestBody Profile profile) {
        return profileService.save(profile);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Profile delete(@RequestBody Profile profile) {
        profileService.delete(profile);
        return profile;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Profile remove(@RequestBody Profile profile) {
        profileService.delete(profile);
        return profile;
    }

    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
    public Profile retrieve(@PathVariable(value = "user_id") long user_id) {
        return profileService.getProfileByUserId(user_id);
    }

}
