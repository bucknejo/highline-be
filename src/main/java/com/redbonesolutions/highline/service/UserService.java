package com.redbonesolutions.highline.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import com.redbonesolutions.highline.domain.*;
import com.redbonesolutions.highline.repository.*;
import org.jasypt.contrib.org.apache.commons.codec_1_3.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.utility.HighlineLogin;
import com.redbonesolutions.highline.utility.HighlineUtility;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GruppeRepository gruppeRepository;

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private PreferencesRepository preferencesRepository;

    @Autowired
    private HighlineLogin highlineLogin;

    public List<User> findAll() {

        // add a test comment for atlassian
        List<User> users = userRepository.findAll();

        for (User user : users) {

            List<Ride> rides = rideRepository.getRidesByUser(user.getId());
            user.setRides(new HashSet<>(rides));

            List<Equipment> equipment = equipmentRepository.getEquipmentByUserId(user.getId());
            user.setEquipment(new HashSet<>(equipment));

            List<Preferences> preferences = preferencesRepository.getPreferencesByUser(user.getId());
            user.setPreferences(new HashSet<>(preferences));

            List<Object[]> friends = userRepository.getFriends(user.getId());
            user.setFriends(new HashSet<>(Friend.convertFriends(friends)));

            for (Gruppe gruppe : user.getGruppes()) {
                List<User> gruppeUsers = userRepository.getUsersInGruppe(gruppe.getId());
                gruppe.setMembers(HighlineUtility.getMembersFromUsers(gruppeUsers));
            }
        }

        return users;
    }

    public User findOne(long id) {

        User user = userRepository.findOne(id);

        List<Equipment> equipment = equipmentRepository.getEquipmentByUserId(id);
        user.setEquipment(new HashSet<>(equipment));

        List<Gruppe> gruppes = gruppeRepository.findAllByUser(id);
        user.setGruppes(new HashSet<>(gruppes));

        List<Ride> rides = rideRepository.getRidesByUser(id);
        user.setRides(new HashSet<>(rides));

        List<Preferences> preferences = preferencesRepository.getPreferencesByUser(id);
        user.setPreferences(new HashSet<>(preferences));

        List<Object[]> friends = userRepository.getFriends(id);
        user.setFriends(new HashSet<>(Friend.convertFriends(friends)));


        for (Gruppe gruppe : user.getGruppes()) {
            List<User> gruppeUsers = userRepository.getUsersInGruppe(gruppe.getId());
            gruppe.setMembers(HighlineUtility.getMembersFromUsers(gruppeUsers));
        }

        return user;
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public List<User> getRidersByRide(long ride_id, long user_id) {
        return userRepository.getRidersByRide(ride_id, user_id);
    };

    // routine to validate User object for storage
    public boolean validateUser(User user) {

        boolean valid = false;

        return valid;

    }

    public HighlineLogin authenticate(String email, String password) {

        User user = userRepository.getUserByEmail(email);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (user != null) {

            highlineLogin.setId(user.getId());

            boolean matches = passwordEncoder.matches(password.concat(user.getSalt()), user.getPassword());
            if (matches) {
                highlineLogin.setAuthenticated(true);
                highlineLogin.setCode(0);
                highlineLogin.setMessage("success");
                highlineLogin.setError("");
            } else {
                highlineLogin.setAuthenticated(false);
                highlineLogin.setCode(-1);
                highlineLogin.setMessage("Failed authentication");
                highlineLogin.setError("Password does not match.");
            }

        } else {
            highlineLogin.setId(-1);
            highlineLogin.setAuthenticated(false);
            highlineLogin.setCode(-2);
            highlineLogin.setMessage("Failed user lookup");
            highlineLogin.setError("Could not find user in data store.");
        }

        return highlineLogin;
    }

    public User createNewUser(String email, String password) {

        User user = new User();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        user.setDate_created(HighlineUtility.getCurrentDate());
        user.setLast_updated(HighlineUtility.getLastModified());
        user.setActive(1);

        user.setEmail(email);
        user.setSalt(this.generateSalt());
        user.setPassword(passwordEncoder.encode(password.concat(user.getSalt())));
        //user.setPassword(passwordEncoder.encode(password));

        user = this.add(user);

        return user;

    }

    public String generateSalt() {

        final Random r = new SecureRandom();
        byte[] s = new byte[32];
        r.nextBytes(s);

        return Base64.encodeBase64(s).toString();

    }

}
