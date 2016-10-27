package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.Address;
import com.redbonesolutions.highline.domain.ui.Option;
import com.redbonesolutions.highline.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Option> getAddressOptions() {
        return addressRepository.getAddressOptions();
    }

    public List<String> getAddressOptionsRaw(Long location_id) {
        return addressRepository.getAddressOptionsRaw(location_id);
    }

    public List<Address> getAddressesByLocationId(long location_id) {
        return addressRepository.getAddressesByLocationId(location_id);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address save(Address a) {
        return addressRepository.save(a);
    }

    public Address add(Address a) {
        return addressRepository.save(a);
    }

    public void delete(Address a) {
        addressRepository.delete(a);
    }

    public Address findOne(long id) {
        return addressRepository.findOne(id);
    }

}
