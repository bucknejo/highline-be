package com.redbonesolutions.highline.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.Friend;
import com.redbonesolutions.highline.domain.User;
import com.redbonesolutions.highline.repository.UserRepository;

@Service
public class FriendService {

    @Autowired
    private UserRepository userRepository;

    public List<Friend> getFriends(long user_id) {

        List<Object[]> objects =userRepository.getFriends(user_id);

        List<Friend> friends = new ArrayList<Friend>();

        for(Object[] o : objects) {
            Friend f = new Friend();
            f.setId((Integer) o[0]);
            f.setDate_created(o[1].toString());
            f.setLast_updated(o[2].toString());
            f.setActive((Integer)o[3]);
            f.setUser_name_internal((o[4] != null ? o[4].toString() : ""));
            f.setUser_name_external((o[5] != null ? o[5].toString() : ""));
            f.setFirst_name(o[6].toString());
            f.setLast_name(o[7].toString());
            f.setPassword(o[8].toString());
            f.setRole_id((Integer)o[9]);
            f.setEmail(o[10].toString());
            f.setSkill(o[11].toString());
            f.setExperience(o[12].toString());
            f.setStyle(o[13].toString());
            f.setGuide((Integer)o[14]);
            f.setSalt(o[15].toString());
            f.setViewable((Integer)o[16]);
            f.setAvatar((o[17] != null ? o[17].toString() : ""));
            f.setGender(o[18].toString());
            f.setReputation((Integer)o[19]);
            f.setStatus((Integer)o[20]);
            friends.add(f);
        }

        return friends;
    }

    public List<User> getFriendsNotInGroup(Long user_id, Long gruppe_id) {
        return userRepository.getFriendsNotInGroup(user_id, gruppe_id);
    }

    public List<User> getFriendsNotInRide(Long user_id, Long ride_id) {
        return userRepository.getFriendsNotInRide(user_id, ride_id, user_id);
    }

}
