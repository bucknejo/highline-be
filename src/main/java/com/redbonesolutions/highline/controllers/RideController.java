package com.redbonesolutions.highline.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redbonesolutions.highline.domain.Ride;
import com.redbonesolutions.highline.domain.ui.Option;
import com.redbonesolutions.highline.service.AddressService;
import com.redbonesolutions.highline.service.RideService;

@RestController
@RequestMapping("/service/ride")
public class RideController {

    private final static Logger LOG = LoggerFactory.getLogger(RideController.class);

    @Autowired
    private RideService rideService;

    @Autowired
    private AddressService addressService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<Ride> rides() {

        List<Ride> rides = rideService.findAll();

        return rides;

    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Ride ride(@PathVariable(value="id") int id) {

        LOG.debug(String.format("id:%s", id));
        System.out.println(String.format("id:%s", id));

        Ride ride = rideService.findOne(id);

        return ride;

    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public Ride addRide(@RequestBody Ride ride) {

        LOG.debug(String.format("add ride: %s", ride.toString()));

        return rideService.add(ride);

    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Ride saveRide(
            @PathVariable("id") int id,
            @RequestBody Ride ride
    ) {


        LOG.debug(String.format("save ride id: %s", id));
        LOG.debug(String.format("save ride: %s", ride.toString()));

        //return ride;
        return rideService.save(ride);


    }

    @RequestMapping(value="/{id}/{user_id}", method = RequestMethod.GET)
    public List<Ride> getRidesByUser(
            @PathVariable("id") int id,
            @PathVariable("user_id") int user_id) {

        LOG.debug(String.format("ride id:%s", id));
        System.out.println(String.format("ride id:%s", id));

        LOG.debug(String.format("ride user_id:%s", user_id));
        System.out.println(String.format("ride user_id:%s", user_id));

        List<Ride> rides = rideService.getRidesByUser(user_id);

        for (Ride r : rides) {
            LOG.debug(String.format("ride: %s", r.toString()));
            System.out.println(String.format("ride: %s", r.toString()));
        }

        return rides;

    }


    @RequestMapping(value="/get/address/options", method = RequestMethod.GET)
    public List<Option> get() {

        return addressService.getAddressOptions();

    }

    @RequestMapping(value="/get/address/options/raw/{location_id}", method = RequestMethod.GET)
    public List<String> getRaw(@PathVariable(value="location_id") Long location_id) {

        LOG.debug(String.format("location_id:%s", location_id));
        System.out.println(String.format("location_id:%s", location_id));

        return addressService.getAddressOptionsRaw(location_id);

    }

    @RequestMapping(value="/gruppe/add/{ride_id}/{gruppe_id}", method = RequestMethod.POST)
    public Ride addGruppeToRide(
            @PathVariable("ride_id") int ride_id,
            @PathVariable("gruppe_id") int gruppe_id) {

        LOG.debug(String.format("ride_id [ride add gruppe]: %s", ride_id));
        LOG.debug(String.format("gruppe_id [ride add gruppe]: %s", gruppe_id));

        Ride ride = rideService.addGruppeToRide(ride_id, gruppe_id);

        LOG.debug(String.format("ride [ride add gruppe]: %s", ride.toString()));

        return ride;

    }



}
