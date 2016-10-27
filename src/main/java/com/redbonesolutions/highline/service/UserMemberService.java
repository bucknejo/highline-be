package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.UserMember;
import com.redbonesolutions.highline.repository.UserMemberRepository;

@Service
public class UserMemberService {

    @Autowired
    private UserMemberRepository userMemberRepository;

    public List<UserMember> findAll() {
        return userMemberRepository.findAll();
    }

    public UserMember findOne(Long id) {
        return userMemberRepository.findOne(id);
    }

    public UserMember add(UserMember um) {
        return userMemberRepository.saveAndFlush(um);
    }

}
