package com.redbonesolutions.highline.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Friend {

    private long id;
    private String date_created;
    private String last_updated;
    private int active;
    private String user_name_internal;
    private String user_name_external;
    private String first_name;
    private String last_name;
    private String password;
    private int role_id;
    private String email;
    private String skill;
    private String experience;
    private String style;
    private int guide;
    private String salt;
    private int viewable;
    private String avatar;
    private String gender;
    private int reputation;
    private int status;

    private Set<UserAddress> addresses;

    private Set<Preferences> preferences;

    public Friend(long id, String date_created, String last_updated,
                  int active, String user_name_internal, String user_name_external,
                  String first_name, String last_name, String password, int role_id,
                  String email, String skill, String experience, String style,
                  int guide, String salt, int viewable, String avatar, String gender,
                  int reputation, int status) {
        super();
        this.id = id;
        this.date_created = date_created;
        this.last_updated = last_updated;
        this.active = active;
        this.user_name_internal = user_name_internal;
        this.user_name_external = user_name_external;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.role_id = role_id;
        this.email = email;
        this.skill = skill;
        this.experience = experience;
        this.style = style;
        this.guide = guide;
        this.salt = salt;
        this.viewable = viewable;
        this.avatar = avatar;
        this.gender = gender;
        this.reputation = reputation;
        this.status = status;
    }

    public Friend() {
        // TODO Auto-generated constructor stub
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getUser_name_internal() {
        return user_name_internal;
    }

    public void setUser_name_internal(String user_name_internal) {
        this.user_name_internal = user_name_internal;
    }

    public String getUser_name_external() {
        return user_name_external;
    }

    public void setUser_name_external(String user_name_external) {
        this.user_name_external = user_name_external;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getGuide() {
        return guide;
    }

    public void setGuide(int guide) {
        this.guide = guide;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getViewable() {
        return viewable;
    }

    public void setViewable(int viewable) {
        this.viewable = viewable;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<UserAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<UserAddress> addresses) {
        this.addresses = addresses;
    }

    public Set<Preferences> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<Preferences> preferences) {
        this.preferences = preferences;
    }

    public static List<Friend> convertFriends(List<Object[]> objects) {

        List<Friend> friends = new ArrayList<>();

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

}
