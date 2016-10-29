package com.redbonesolutions.highline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redbonesolutions.highline.domain.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    @Query(value = "select * from equipment where user_id = :user_id", nativeQuery=true)
    List<Equipment> getEquipmentByUserId(@Param("user_id") Long user_id);

}
