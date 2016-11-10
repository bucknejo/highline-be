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

        return Friend.convertFriends(objects);

    }

    public List<User> getFriendsNotInGroup(Long user_id, Long gruppe_id) {
        return userRepository.getFriendsNotInGroup(user_id, gruppe_id);
    }

    public List<User> getFriendsNotInRide(Long user_id, Long ride_id) {
        return userRepository.getFriendsNotInRide(user_id, ride_id, user_id);
    }

}
