package com.redbonesolutions.highline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redbonesolutions.highline.domain.LocationResource;

public interface LocationResourceRepository extends JpaRepository<LocationResource, Long> {

    @Query(value = "select * from location_resources where location_id = :location_id", nativeQuery=true)
    List<LocationResource> getLocationResourcesById(@Param("location_id") Long group_id);

}
