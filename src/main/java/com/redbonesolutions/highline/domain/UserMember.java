package com.redbonesolutions.highline.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table (name = "user_members")
public class UserMember extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    private String date_created;
    private String last_updated;
    private int active;
    private int user_id;
    private int friend_id;
    private int clique_id;
    private int status;

    public UserMember() {}

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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public int getClique_id() {
        return clique_id;
    }

    public void setClique_id(int clique_id) {
        this.clique_id = clique_id;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return false;
    }

}
