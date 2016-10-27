package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.Gruppe;
import com.redbonesolutions.highline.domain.Ride;
import com.redbonesolutions.highline.domain.RideMember;
import com.redbonesolutions.highline.domain.User;
import com.redbonesolutions.highline.repository.RideRepository;
import com.redbonesolutions.highline.utility.HighlineUtility;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private GruppeService gruppeService;

    @Autowired
    private RideMemberService rideMemberService;

    public List<Ride> findAll() {
        return rideRepository.findAll();
    }

    public Ride save(Ride r) {
        return rideRepository.save(r);
    }

    public Ride add(Ride r) {

        r.setDate_created(HighlineUtility.getCurrentDate());
        r.setLast_updated(HighlineUtility.getLastModified());
        r.setActive(1);

        return rideRepository.save(r);
    }

    public void delete(Ride r) {
        rideRepository.delete(r);
    }

    public Ride findOne(long id) {
        return rideRepository.findOne(id);
    }

    public List<Ride> getRidesByUser(long user_id) {
        return rideRepository.getRidesByUser(user_id);
    }

    public Ride addGruppeToRide(long ride_id, long gruppe_id) {

        Ride r = this.findOne(ride_id);

        Gruppe gruppe = gruppeService.findOne(gruppe_id);

        for (User u : gruppe.getMembers()) {

            RideMember rm = rideMemberService.getRideMemberByRideAndUser(ride_id, u.getId());

            if (rm == null) {
                rm = new RideMember();
                rm.setDate_created(HighlineUtility.getCurrentDate());
                rm.setLast_updated(HighlineUtility.getLastModified());
                rm.setActive(1);
                rm.setRide_id(ride_id);
                rm.setUser_id(u.getId());
                rm.setGroup_id(gruppe_id);
                rm.setRsvp(0);
                rm.setStatus("ON TIME");
                rm.setComplete(0);
                rm.setRating(0);
                rm.setComment("");
                rm = rideMemberService.save(rm);
            }

        }

        return r;

    }

}
