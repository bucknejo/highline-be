package com.redbonesolutions.highline.repository;

import com.redbonesolutions.highline.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query(value = "select * from activity where user_id = :user_id", nativeQuery=true)
    List<Activity> getActivitiesByUserId(@Param("user_id") Long user_id);

}
