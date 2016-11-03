package com.redbonesolutions.highline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redbonesolutions.highline.domain.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {}
