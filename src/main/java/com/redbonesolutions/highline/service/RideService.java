package com.redbonesolutions.highline.service;

import java.util.ArrayList;
import java.util.List;

import com.redbonesolutions.highline.domain.*;
import com.redbonesolutions.highline.domain.Activity;
import com.redbonesolutions.highline.models.RideModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.repository.RideRepository;
import com.redbonesolutions.highline.utility.HighlineUtility;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private GruppeService gruppeService;

    @Autowired
    private LocationService locationService;

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

    public List<RideModel> getActivityStreamByUser(long user_id) {
        List<RideModel> models = new ArrayList<RideModel>();
        List<Ride> rides = rideRepository.getRidesByUser(user_id);

        for (Ride ride : rides) {
            Location location = locationService.findOne(ride.getLocation_id());
            String gruppe_name = gruppeService.findNameById(ride.getGroup_id());

            RideModel model = new RideModel();
            model.setId(ride.getId());
            model.setName(ride.getName());
            model.setDescription(ride.getDescription());
            model.setGruppe(gruppe_name);
            model.setLocation(location.getName());
            model.setDate(ride.getDate());
            model.setTime(ride.getTime());
            model.setStatus(ride.getStatus());
            model.setJoinable(ride.getJoinable());
            model.setTempo(ride.getTempo());
            model.setDrop(ride.getDrop());
            model.setAvailable(ride.getAvailable());
            models.add(model);
        }

        return models;
    }

    public Ride addGruppeToRide(long ride_id, long gruppe_id) {

        Ride r = this.findOne(ride_id);

        Gruppe gruppe = gruppeService.findOne(gruppe_id);

        for (GruppeMember member : gruppe.getMembers()) {

            RideMember rm = rideMemberService.getRideMemberByRideAndUser(ride_id, member.getUser_id());

            if (rm == null) {
                rm = new RideMember();
                rm.setDate_created(HighlineUtility.getCurrentDate());
                rm.setLast_updated(HighlineUtility.getLastModified());
                rm.setActive(1);
                rm.setRide_id(ride_id);
                rm.setUser_id(member.getUser_id());
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
