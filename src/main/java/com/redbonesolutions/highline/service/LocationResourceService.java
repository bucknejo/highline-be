package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.LocationResource;
import com.redbonesolutions.highline.repository.LocationResourceRepository;

@Service
public class LocationResourceService {

    @Autowired
    private LocationResourceRepository locationResourceRepository;

    public List<LocationResource> findAll() {
        return locationResourceRepository.findAll();
    }

    public LocationResource save(LocationResource lr) {
        return locationResourceRepository.save(lr);
    }

    public void delete(LocationResource lr) {
        locationResourceRepository.delete(lr);
    }

    public LocationResource findOne(long id) {
        return locationResourceRepository.findOne(id);
    }
}
