package com.redbonesolutions.highline.controllers;

import com.redbonesolutions.highline.domain.Preferences;
import com.redbonesolutions.highline.service.PreferencesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/preferences")
public class PreferencesController {

    private final static Logger LOG = LoggerFactory.getLogger(PreferencesController.class);

    @Autowired
    private PreferencesService preferencesService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Preferences> getPreferences() {
        return preferencesService.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Preferences getPreference(@PathVariable(value = "id") long id) {
        return preferencesService.findOne(id);
    }

    @RequestMapping(value="", method = RequestMethod.PUT)
    public Preferences addPreference(@RequestBody Preferences preferences) {
        return preferencesService.save(preferences);
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public Preferences savePreference(@RequestBody Preferences preferences) {
        return preferencesService.save(preferences);
    }

    @RequestMapping(value="", method = RequestMethod.DELETE)
    public Preferences deletePreference(@RequestBody Preferences preferences) {
        preferencesService.delete(preferences);
        return preferences;
    }

}
