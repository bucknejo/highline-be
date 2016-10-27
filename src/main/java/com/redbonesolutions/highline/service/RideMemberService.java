package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.RideMember;
import com.redbonesolutions.highline.repository.RideMemberRepository;
import com.redbonesolutions.highline.utility.HighlineUtility;

@Service
public class RideMemberService {

    @Autowired
    private RideMemberRepository rideMemberRepository;

    public RideMember findOne(long id) {
        return rideMemberRepository.findOne(id);
    }

    public List<RideMember> findAll() {
        return rideMemberRepository.findAll();
    }

    public RideMember add(RideMember rm) {

        RideMember rider = rideMemberRepository.getRideMemberByRideAndUser(rm.getRide_id(), rm.getUser_id());

        // add new rider to ride if rider does not already exist
        if (rider == null) {
            rider = rideMemberRepository.save(rm);
        }

        return rider;
    }

    public RideMember save(RideMember rm) {
        return rideMemberRepository.save(rm);
    }

    public void deleteMember(RideMember rm) {
        rideMemberRepository.delete(rm);
    }

    public RideMember addRideMemberByRideAndUser(int ride_id, int user_id) {

        RideMember rm = new RideMember();
        rm.setDate_created(HighlineUtility.getCurrentDate());
        rm.setLast_updated(HighlineUtility.getLastModified());
        rm.setActive(1);
        rm.setRide_id(ride_id);
        rm.setUser_id(user_id);
        rm.setGroup_id(0);
        rm.setRsvp(0);
        rm.setStatus("ON TIME");
        rm.setComplete(0);
        rm.setRating(0);
        rm.setComment("");

        rm = rideMemberRepository.save(rm);

        return rm;

    }

    public RideMember getRideMemberByRideAndUser(long ride_id, long user_id) {
        return rideMemberRepository.getRideMemberByRideAndUser(ride_id, user_id);
    }



}
