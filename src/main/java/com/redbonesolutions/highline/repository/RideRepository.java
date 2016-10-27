package com.redbonesolutions.highline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redbonesolutions.highline.domain.Ride;

public interface RideRepository extends JpaRepository<Ride, Long> {

    @Query(value="select * from ride where user_id = :user_id", nativeQuery=true)
    List<Ride> getRidesByUser(@Param("user_id") long user_id);

}
