package com.redbonesolutions.highline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redbonesolutions.highline.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query(value = "select * from location where state = :state", nativeQuery=true)
    List<Location> getLocationsOptionsByState(@Param("state") String state);

}
