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

import com.redbonesolutions.highline.domain.RideMember;
import com.redbonesolutions.highline.service.RideMemberService;

@RestController
@RequestMapping("/service/ridemember")
public class RideMemberController {

    private final static Logger LOG = LoggerFactory.getLogger(RideMemberController.class);

    @Autowired
    private RideMemberService rideMemberService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<RideMember> getAllRideMembers() {
        return rideMemberService.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public RideMember getOneRideMember(@PathVariable(value="id") int id) {

        LOG.debug(String.format("id:%s", id));
        System.out.println(String.format("id:%s", id));

        return rideMemberService.findOne(id);

    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public RideMember addRideMember(@RequestBody RideMember rm) {
        return rideMemberService.add(rm);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public RideMember saveRideMember(
            @PathVariable(value="id") int id,
            @RequestBody RideMember rm) {

        LOG.debug(String.format("id:%s", id));
        System.out.println(String.format("id:%s", id));

        return rideMemberService.save(rm);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public RideMember deleteRideMember(@PathVariable(value="id") int id) {

        LOG.debug(String.format("id:%s", id));
        System.out.println(String.format("id:%s", id));

        RideMember rm = rideMemberService.findOne(id);
        rideMemberService.deleteMember(rm);
        return rm;
    }

    @RequestMapping(value="/{ride_id}/{user_id}", method = RequestMethod.POST)
    public RideMember addRideMemberByRideAndUser(
            @PathVariable(value="ride_id") int ride_id,
            @PathVariable(value="user_id") int user_id) {

        LOG.debug(String.format("ride_id: %s", ride_id));
        System.out.println(String.format("ride_id: %s", ride_id));

        LOG.debug(String.format("user_id: %s", user_id));
        System.out.println(String.format("user_id: %s", user_id));

        RideMember rm = rideMemberService.addRideMemberByRideAndUser(ride_id, user_id);

        LOG.debug(String.format("added rm: %s", rm.toString()));
        System.out.println(String.format("added rm: %s", rm.toString()));

        return rm;
    }

    @RequestMapping(value="/{ride_id}/{user_id}", method = RequestMethod.DELETE)
    public RideMember deleteRideMemberByRideAndUser(
            @PathVariable(value="ride_id") int ride_id,
            @PathVariable(value="user_id") int user_id) {

        LOG.debug(String.format("ride_id: %s", ride_id));
        System.out.println(String.format("ride_id: %s", ride_id));

        LOG.debug(String.format("user_id: %s", user_id));
        System.out.println(String.format("user_id: %s", user_id));

        RideMember rm = rideMemberService.getRideMemberByRideAndUser(ride_id, user_id);
        rideMemberService.deleteMember(rm);

        LOG.debug(String.format("rm: %s", rm.toString()));
        System.out.println(String.format("rm: %s", rm.toString()));


        return rm;
    }


}
