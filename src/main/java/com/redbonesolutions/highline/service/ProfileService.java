package com.redbonesolutions.highline.service;

import com.redbonesolutions.highline.domain.Profile;
import com.redbonesolutions.highline.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile findOne(long id) {
        return profileRepository.findOne(id);
    }

    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile add(Profile profile) {
        return profileRepository.save(profile);
    }

    public void delete(Profile profile) {
        profileRepository.delete(profile);
    }

    public Profile getProfileByUserId(long user_id) {
        return profileRepository.getProfileByUserId(user_id);
    }

}
