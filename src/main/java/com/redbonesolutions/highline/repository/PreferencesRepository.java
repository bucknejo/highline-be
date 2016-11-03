package com.redbonesolutions.highline.repository;

import com.redbonesolutions.highline.domain.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PreferencesRepository extends JpaRepository<Preferences, Long> {

    @Query(value="select * from preferences where user_id = :user_id", nativeQuery=true)
    List<Preferences> getPreferencesByUser(@Param("user_id") long user_id);

}
