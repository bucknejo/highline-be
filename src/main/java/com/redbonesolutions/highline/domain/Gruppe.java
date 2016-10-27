package com.redbonesolutions.highline.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table (name = "gruppe")
public class Gruppe extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    private String date_created;
    private String last_updated;
    private int active;
    private String name;
    private String description;
    private int user_id;
    private int deputy;
    private int type;
    private int joinable;
    private int locked;

    @Transient
    private User user;

    @Transient
    private List<User> members;

    public Gruppe() {}

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDeputy() {
        return deputy;
    }

    public void setDeputy(int deputy) {
        this.deputy = deputy;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getJoinable() {
        return joinable;
    }

    public void setJoinable(int joinable) {
        this.joinable = joinable;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> list) {
        this.members = list;
    }

}
