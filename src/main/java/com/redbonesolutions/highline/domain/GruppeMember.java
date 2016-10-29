package com.redbonesolutions.highline.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table (name = "gruppe_members")
public class GruppeMember extends AbstractPersistable<Long>{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String date_created;
    private String last_updated;
    private int active;
    private int gruppe_id;
    private long user_id;
    private String role;

    @Transient
    private String first_name;
    @Transient
    private String last_name;
    @Transient
    private String email;
    @Transient
    private String skill;
    @Transient
    private int experience;
    @Transient
    private String style;
    @Transient
    private int reputation;

    public GruppeMember() {

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

    public int getGruppe_id() {
        return gruppe_id;
    }

    public void setGruppe_id(int gruppe_id) {
        this.gruppe_id = gruppe_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return false;
    }

}
