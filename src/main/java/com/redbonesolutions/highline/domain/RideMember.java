package com.redbonesolutions.highline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table (name= "ride_members")
public class RideMember extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    private String date_created;
    private String last_updated;
    private int active;
    private long ride_id;
    private long user_id;
    private long group_id;
    private int rsvp;
    private String status;
    private int complete;
    private int rating;
    @Column(nullable = true)
    private String comment;

    public RideMember() {

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

    public long getRide_id() {
        return ride_id;
    }

    public void setRide_id(long ride_id) {
        this.ride_id = ride_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public int getRsvp() {
        return rsvp;
    }

    public void setRsvp(int rsvp) {
        this.rsvp = rsvp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return false;
    }

    @Override
    public String toString() {
        return "RideMember [date_created=" + date_created + ", last_updated="
                + last_updated + ", active=" + active + ", ride_id=" + ride_id
                + ", user_id=" + user_id + ", group_id=" + group_id + ", rsvp="
                + rsvp + ", status=" + status + ", complete=" + complete
                + ", rating=" + rating + ", comment=" + comment + "]";
    }

}
