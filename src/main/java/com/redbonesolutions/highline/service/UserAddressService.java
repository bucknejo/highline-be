package com.redbonesolutions.highline.service;

import com.redbonesolutions.highline.domain.UserAddress;
import com.redbonesolutions.highline.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    public List<UserAddress> findAll() {
        return userAddressRepository.findAll();
    }

    public UserAddress findOne(long id) {
        return userAddressRepository.findOne(id);
    }

    public UserAddress save(UserAddress userAddress) {
        return userAddressRepository.save(userAddress);
    }

    public UserAddress add(UserAddress userAddress) {
        return userAddressRepository.save(userAddress);
    }

    public void delete(UserAddress userAddress) {
        userAddressRepository.delete(userAddress);
    }

    public List<UserAddress> findUserAddressesByUserId(long user_id) {
        return userAddressRepository.findUserAddressesByUserId(user_id);
    }
}
