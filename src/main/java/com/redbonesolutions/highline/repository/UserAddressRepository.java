package com.redbonesolutions.highline.repository;

import com.redbonesolutions.highline.domain.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

    @Query(value = "select * from user_address where user_id = :user_id", nativeQuery=true)
    List<UserAddress> findUserAddressesByUserId(@Param("user_id") Long user_id);

}
