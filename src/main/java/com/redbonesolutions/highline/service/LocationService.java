package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.Location;
import com.redbonesolutions.highline.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location findOne(long id) {
        Location location = locationRepository.findOne(id);
        return location;
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Location save(Location l) {
        return locationRepository.save(l);
    }

    public void delete(Location l) {
        locationRepository.delete(l);
    }

    public List<Location> getLocationsOptionsByState(String state) {
        return locationRepository.getLocationsOptionsByState(state);
    }

}
