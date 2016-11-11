package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.Equipment;
import com.redbonesolutions.highline.repository.EquipmentRepository;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> getEquipmentByUserId(Long user_id) {
        return equipmentRepository.getEquipmentByUserId(user_id);
    }

    public Equipment getEquipmentByIdAndUserId(long id, long user_id) {
        return equipmentRepository.getEquipmentByIdAndUserId(id, user_id);
    }

    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    public Equipment save(Equipment e) {
        return equipmentRepository.save(e);
    }

    public Equipment add(Equipment e) {
        return equipmentRepository.save(e);
    }

    public void delete(Equipment e) {
        equipmentRepository.delete(e);
    }

    public Equipment findOne(long id) {
        return equipmentRepository.findOne(id);
    }

}
