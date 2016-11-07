package com.redbonesolutions.highline.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redbonesolutions.highline.domain.User;
import com.redbonesolutions.highline.service.MemberService;

@RestController
@RequestMapping("/service/member")
@CrossOrigin(origins = "http://localhost:8090")
public class MemberController {

    private final static Logger LOG = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    // get all members
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public List<User> getMembers(@PathVariable(value="id") int id) {

        LOG.debug(String.format("member id:%s", id));
        System.out.println(String.format("member id:%s", id));

        List<User> users = memberService.getMembers(id);

        return users;

    }


}
