package com.redbonesolutions.highline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redbonesolutions.highline.domain.Address;
import com.redbonesolutions.highline.domain.ui.Option;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "select id, description from address", nativeQuery=true)
    List<Option> getAddressOptions();

    @Query(value = "select concat(id, ':', description) from address where type = 'LOCATION' and type_id = :location_id", nativeQuery=true)
    List<String> getAddressOptionsRaw(@Param("location_id") Long location_id);

    @Query(value = "select * from address where type = 'LOCATION' and type_id = :location_id", nativeQuery=true)
    List<Address> getAddressesByLocationId(@Param("location_id") Long location_id);

}
