package com.redbonesolutions.highline.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redbonesolutions.highline.domain.Address;
import com.redbonesolutions.highline.service.AddressService;

@RestController
@RequestMapping("/service/address")
public class AddressController {

    private final static Logger LOG = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public List<Address> getAllAddresses() {
        List<Address> addresses = addressService.findAll();
        return addresses;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Address getOneAddress(@PathVariable(value="id") int id) {
        Address address = addressService.findOne(id);
        return address;
    }

    @RequestMapping(value="", method=RequestMethod.PUT)
    public Address addAddress(@RequestBody Address address) {
        return addressService.add(address);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public Address saveAddress(
            @PathVariable(value="id") int id,
            @RequestBody Address address) {

        return addressService.save(address);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public Address deleteAddress(@PathVariable(value="id") int id) {

        Address address = addressService.findOne(id);
        addressService.delete(address);
        return address;

    }

    @RequestMapping(value="/{id}/{location_id}", method=RequestMethod.GET)
    public List<Address> getAddressesByLocationId(
            @PathVariable(value="id") int id,
            @PathVariable(value="location_id") int location_id) {

        LOG.debug(String.format("address id: %s", id));
        System.out.println(String.format("address id: %s", id));

        LOG.debug(String.format("location id: %s", id));
        System.out.println(String.format("location id: %s", id));

        List<Address> addresses = addressService.getAddressesByLocationId(location_id);

        for (Address a : addresses) {
            LOG.debug(String.format("address: %s", a.toString()));
            System.out.println(String.format("address: %s", a.toString()));
        }

        return addresses;

    }

    @RequestMapping(value = "/id/{id}/user/{user_id}", method = RequestMethod.GET)
    public Address findUserAddressesByIdAndUserId(
            @PathVariable(value="id") long id,
            @PathVariable(value="user_id") long user_id) {

        return addressService.findUserAddressesByIdAndUserId(id, user_id);

    }

}
