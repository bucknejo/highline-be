package com.redbonesolutions.highline.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table (name = "user")
public class User extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

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
    private int experience;
    private String style;
    private int guide;
    private String salt;
    private int viewable;
    private String avatar;
    private String gender;
    private int reputation;

    // equipment
    @Transient
    private Set<Equipment> equipment;

    // friends
    @Transient
    private Set<Friend> friends;

    // available
    @Transient
    private List<User> available;

    // groups
    @Transient
    private Set<Gruppe> gruppes;

    // rides
    @Transient
    private Set<Ride> rides;

    // preferences
    @Transient
    private Set<Preferences> preferences;

    @Transient
    private Set<Address> addresses;

    public User() {}

    public void setId(long id) {
        super.setId(id);
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
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

    public Set<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(Set<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }

    public List<User> getAvailable() {
        return available;
    }

    public void setAvailable(List<User> available) {
        this.available = available;
    }

    public Set<Gruppe> getGruppes() {
        return gruppes;
    }

    public void setGruppes(Set<Gruppe> gruppes) {
        this.gruppes = gruppes;
    }

    public Set<Ride> getRides() {
        return rides;
    }

    public void setRides(Set<Ride> rides) {
        this.rides = rides;
    }

    public Set<Preferences> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<Preferences> preferences) {
        this.preferences = preferences;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "date_created='" + date_created + '\'' +
                ", last_updated='" + last_updated + '\'' +
                ", active=" + active +
                ", user_name_internal='" + user_name_internal + '\'' +
                ", user_name_external='" + user_name_external + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", role_id=" + role_id +
                ", email='" + email + '\'' +
                ", skill='" + skill + '\'' +
                ", experience=" + experience +
                ", style='" + style + '\'' +
                ", guide=" + guide +
                ", salt='" + salt + '\'' +
                ", viewable=" + viewable +
                ", avatar='" + avatar + '\'' +
                ", gender='" + gender + '\'' +
                ", reputation=" + reputation +
                ", equipment=" + equipment +
                ", friends=" + friends +
                ", available=" + available +
                ", gruppes=" + gruppes +
                ", rides=" + rides +
                ", preferences=" + preferences +
                '}';
    }
}
