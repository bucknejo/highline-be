package com.redbonesolutions.highline.utility;

import com.redbonesolutions.highline.domain.GruppeMember;
import com.redbonesolutions.highline.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HighlineUtility {

    public static String getCurrentDate() {
        String currentDate;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        currentDate = sdf.format(d);
        return currentDate;
    }

    public static String getLastModified() {
        String lastModified;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        lastModified = sdf.format(d);
        return lastModified;
    }

    public static List<GruppeMember> getMembersFromUsers(List<User> gruppeUsers) {

        List<GruppeMember> members = new ArrayList<>();

        for (User u : gruppeUsers) {
            GruppeMember member = new GruppeMember();
            member.setUser_id(u.getId());
            member.setActive(u.getActive());
            member.setFirst_name(u.getFirst_name());
            member.setLast_name(u.getLast_name());
            member.setEmail(u.getEmail());
            member.setSkill(u.getSkill());
            member.setExperience(u.getExperience());
            member.setStyle(u.getStyle());
            member.setReputation(u.getReputation());
            members.add(member);
        }

        return members;

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
