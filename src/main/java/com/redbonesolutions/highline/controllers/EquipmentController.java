package com.redbonesolutions.highline.controllers;

import com.redbonesolutions.highline.domain.Equipment;
import com.redbonesolutions.highline.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Equipment> getAllEquipment() {
        return equipmentService.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Equipment getOneEquipment(@PathVariable(value="id") long id) {
        return equipmentService.findOne(id);
    }

    @RequestMapping(value="", method = RequestMethod.PUT)
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return equipmentService.add(equipment);
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public Equipment saveEquipment(@RequestBody Equipment equipment) {
        return equipmentService.save(equipment);
    }

    @RequestMapping(value="", method = RequestMethod.DELETE)
    public Equipment deleteEquipment(@RequestBody Equipment equipment) {
        equipmentService.delete(equipment);
        return equipment;
    }

    @RequestMapping(value="/id/{id}/user/{user_id}", method = RequestMethod.GET)
    public Equipment getEquipmentByIdAndUserId(
            @PathVariable(value="id") long id,
            @PathVariable(value="user_id") long user_id) {
        return equipmentService.getEquipmentByIdAndUserId(id, user_id);
    }

}
