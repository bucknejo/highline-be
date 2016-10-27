package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.Rider;
import com.redbonesolutions.highline.repository.RiderRepository;

@Service
public class RiderService {

    @Autowired
    private RiderRepository riderRepository;

    public List<Rider> findAll() {
        return riderRepository.findAll();
    }

    public Rider save(Rider r) {
        return riderRepository.save(r);
    }

    public void delete(Rider r) {
        riderRepository.delete(r);
    }

    public Rider findOne(long id) {
        return riderRepository.findOne(id);
    }

}
