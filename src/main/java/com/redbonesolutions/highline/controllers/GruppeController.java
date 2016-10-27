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

import com.redbonesolutions.highline.domain.Gruppe;
import com.redbonesolutions.highline.service.GruppeService;

@RestController
@RequestMapping("/service/gruppe")
public class GruppeController {

    private final static Logger LOG = LoggerFactory.getLogger(GruppeController.class);

    @Autowired
    private GruppeService gruppeService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Gruppe> getGruppes() {
        List<Gruppe> gruppes = gruppeService.findAll();
        return gruppes;
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    public List<Gruppe> getGruppesByUser(@PathVariable(value="id") long id) {

        LOG.debug(String.format("get by user id:%s", id));
        System.out.println(String.format("get by user id:%s", id));

        List<Gruppe> gruppes = gruppeService.findAllByUser(id);
        return gruppes;
    }


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Gruppe getGruppe(@PathVariable(value="id") long id) {

        LOG.debug(String.format("get id:%s", id));
        System.out.println(String.format("get id:%s", id));

        Gruppe gruppe = gruppeService.findOne(id);
        return gruppe;

    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public Gruppe addGruppe(@RequestBody Gruppe gruppe) {

        Gruppe g = gruppeService.add(gruppe);
        return g;

    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Gruppe saveGroup(
            @PathVariable(value="id") int id,
            @RequestBody Gruppe gruppe
    ) {

        LOG.debug(String.format("save id:%s", id));
        System.out.println(String.format("save id:%s", id));

        LOG.debug(String.format("Save Group: %s", gruppe.toString()));
        System.out.println(String.format("Save Group: %s", gruppe.toString()));

        Gruppe g = gruppeService.save(gruppe);
        return g;

    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public Gruppe deleteGroup(@PathVariable(value="id") int id) {

        LOG.debug(String.format("delete id:%s", id));
        System.out.println(String.format("delete id:%s", id));

        Gruppe g = gruppeService.findOne(id);
        gruppeService.delete(g);
        return g;

    }




}
