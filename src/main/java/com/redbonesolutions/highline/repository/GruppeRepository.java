package com.redbonesolutions.highline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redbonesolutions.highline.domain.Gruppe;

public interface GruppeRepository extends JpaRepository<Gruppe, Long> {

    @Query(value = "select * from gruppe where user_id = :user_id", nativeQuery=true)
    List<Gruppe> findAllByUser(@Param("user_id") Long user_id);

    @Query(value = "select name from gruppe where id = :id", nativeQuery=true)
    String findNameById(@Param("id") Long id);

}
