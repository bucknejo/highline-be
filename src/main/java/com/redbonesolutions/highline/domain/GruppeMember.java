package com.redbonesolutions.highline.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

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
    private int user_id;
    private String role;

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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
