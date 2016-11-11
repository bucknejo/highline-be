package com.redbonesolutions.highline.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.redbonesolutions.highline.domain.Preferences;
import com.redbonesolutions.highline.domain.UserAddress;
import com.redbonesolutions.highline.repository.PreferencesRepository;
import com.redbonesolutions.highline.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.Friend;
import com.redbonesolutions.highline.domain.User;
import com.redbonesolutions.highline.repository.UserRepository;

@Service
public class FriendService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private PreferencesRepository preferencesRepository;

    public List<Friend> getFriends(long user_id) {

        List<Object[]> objects = userRepository.getFriends(user_id);

        List<Friend> friends = Friend.convertFriends(objects);

        for (Friend friend : friends) {
            List<UserAddress> addresses = userAddressRepository.findUserAddressesByUserId(friend.getId());
            friend.setAddresses(new HashSet<>(addresses));

            List<Preferences> preferences = preferencesRepository.getPreferencesByUser(friend.getId());
            friend.setPreferences(new HashSet<>(preferences));
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
