package com.redbonesolutions.highline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.repository.UserRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;



}
