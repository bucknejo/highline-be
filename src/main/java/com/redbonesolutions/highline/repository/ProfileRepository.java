package com.redbonesolutions.highline.repository;

import com.redbonesolutions.highline.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query(value="select * from profile where user_id = :user_id", nativeQuery = true)
    Profile getProfileByUserId(@Param("user_id") long user_id);
}
