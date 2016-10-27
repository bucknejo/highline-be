package com.redbonesolutions.highline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redbonesolutions.highline.domain.Rider;

public interface RiderRepository extends JpaRepository<Rider, Long> {

}
