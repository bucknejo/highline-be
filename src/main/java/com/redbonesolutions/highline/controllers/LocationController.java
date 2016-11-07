package com.redbonesolutions.highline.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redbonesolutions.highline.domain.Location;
import com.redbonesolutions.highline.service.LocationService;

@RestController
@RequestMapping("/service/location")
@CrossOrigin(origins = "http://localhost:8090")
public class LocationController {

    private final static Logger LOG = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Location> getAllLocations() {

        return locationService.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Location getOneLocation(@PathVariable(value="id") int id) {

        LOG.debug(String.format("id:%s", id));
        System.out.println(String.format("id:%s", id));

        Location location = locationService.findOne(id);

        return location;

    }

    @RequestMapping(value="/{id}/{state}", method = RequestMethod.GET)
    public List<Location> getLocationOptionsByState(@PathVariable(value="state") String state) {

        List<Location> locations = locationService.getLocationsOptionsByState(state);

        for (Location location : locations) {
            System.out.println(String.format("location %s: ", location.toString()));
        }
        return locations;

    }

}
