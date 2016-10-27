package com.redbonesolutions.highline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redbonesolutions.highline.domain.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

}
