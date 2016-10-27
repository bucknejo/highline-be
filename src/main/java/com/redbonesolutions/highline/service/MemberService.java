package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.User;
import com.redbonesolutions.highline.repository.UserRepository;

@Service
public class MemberService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getMembers(long user_id) {
        return userRepository.getMembers(user_id, user_id);
    }

}
