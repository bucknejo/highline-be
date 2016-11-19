package com.redbonesolutions.highline.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redbonesolutions.highline.domain.GruppeMember;
import com.redbonesolutions.highline.service.GruppeMemberService;

@RestController
@RequestMapping("/service/gruppemember")
public class GruppeMemberController {

    private final static Logger LOG = LoggerFactory.getLogger(GruppeMemberController.class);

    @Autowired
    private GruppeMemberService gruppeMemberService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<GruppeMember> getGruppes() {
        List<GruppeMember> gruppemembers = gruppeMemberService.findAll();
        return gruppemembers;
    }

    @RequestMapping(value="/{id}/{gruppe_id}/{user_id}", method = RequestMethod.GET)
    public GruppeMember retrieve(
            @PathVariable(value="id") long id,
            @PathVariable(value="gruppe_id") long gruppe_id,
            @PathVariable(value="user_id") long user_id
    ) {

        LOG.debug(String.format("get id:%s", id));
        System.out.println(String.format("get id:%s", id));

        LOG.debug(String.format("get gruppe_id:%s", gruppe_id));
        System.out.println(String.format("get gruppe_id:%s", gruppe_id));

        LOG.debug(String.format("get user_id:%s", user_id));
        System.out.println(String.format("get user_id:%s", user_id));

        GruppeMember g = gruppeMemberService.findByGruppeIdAndUserId(gruppe_id, user_id);

        return g;

    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public GruppeMember addGruppeMember(@RequestBody GruppeMember gm) {

        GruppeMember g = gruppeMemberService.add(gm);
        return g;

    }

    // probably will go unused unless we add more fields to the table or use the role
    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
    public GruppeMember saveGruppeMember(
            @PathVariable(value="id") int id,
            @RequestBody GruppeMember gm
    ) {

        LOG.debug(String.format("save id:%s", id));
        System.out.println(String.format("save id:%s", id));

        LOG.debug(String.format("Save GroupMember: %s", gm.toString()));
        System.out.println(String.format("Save GroupMember: %s", gm.toString()));

        GruppeMember g = gruppeMemberService.save(gm);
        return g;

    }

    @RequestMapping(value="/{id}/{gruppe_id}/{user_id}", method = RequestMethod.DELETE)
    public GruppeMember deleteGruppe(
            @PathVariable(value="id") int id,
            @PathVariable(value="gruppe_id") long gruppe_id,
            @PathVariable(value="user_id") long user_id
    ) {

        LOG.debug(String.format("delete id:%s", id));
        System.out.println(String.format("delete id:%s", id));

        LOG.debug(String.format("delete gruppe_id:%s", gruppe_id));
        System.out.println(String.format("delete gruppe_id:%s", gruppe_id));

        LOG.debug(String.format("delete user_id:%s", user_id));
        System.out.println(String.format("delete user_id:%s", user_id));

        GruppeMember gm = gruppeMemberService.findByGruppeIdAndUserId(gruppe_id, user_id);
        gruppeMemberService.delete(gm);
        return gm;

    }




}
