package com.redbonesolutions.highline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redbonesolutions.highline.domain.RideMember;

public interface RideMemberRepository extends JpaRepository<RideMember, Long> {

    @Query(value="select * from ride_members where ride_id = :ride_id and user_id = :user_id", nativeQuery=true)
    RideMember getRideMemberByRideAndUser(@Param("ride_id") long ride_id, @Param("user_id") long user_id);
}
