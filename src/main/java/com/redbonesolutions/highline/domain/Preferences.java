package com.redbonesolutions.highline.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "preferences")
public class Preferences extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    private String date_created;
    private String last_updated;
    private int active;
    private int user_id;
    private int access_profile;
    private int access_groups;
    private int access_friends;
    private int access_rides;
    private int access_photos;
    private int notify_email_activity;
    private int notify_email_alerts;
    private int notify_sms_activity;
    private int notify_sms_alerts;

    public Preferences() {}

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

    public int getAccess_profile() {
        return access_profile;
    }

    public void setAccess_profile(int access_profile) {
        this.access_profile = access_profile;
    }

    public int getAccess_groups() {
        return access_groups;
    }

    public void setAccess_groups(int access_groups) {
        this.access_groups = access_groups;
    }

    public int getAccess_friends() {
        return access_friends;
    }

    public void setAccess_friends(int access_friends) {
        this.access_friends = access_friends;
    }

    public int getAccess_rides() {
        return access_rides;
    }

    public void setAccess_rides(int access_rides) {
        this.access_rides = access_rides;
    }

    public int getAccess_photos() {
        return access_photos;
    }

    public void setAccess_photos(int access_photos) {
        this.access_photos = access_photos;
    }

    public int getNotify_email_activity() {
        return notify_email_activity;
    }

    public void setNotify_email_activity(int notify_email_activity) {
        this.notify_email_activity = notify_email_activity;
    }

    public int getNotify_email_alerts() {
        return notify_email_alerts;
    }

    public void setNotify_email_alerts(int notify_email_alerts) {
        this.notify_email_alerts = notify_email_alerts;
    }

    public int getNotify_sms_activity() {
        return notify_sms_activity;
    }

    public void setNotify_sms_activity(int notify_sms_activity) {
        this.notify_sms_activity = notify_sms_activity;
    }

    public int getNotify_sms_alerts() {
        return notify_sms_alerts;
    }

    public void setNotify_sms_alerts(int notify_sms_alerts) {
        this.notify_sms_alerts = notify_sms_alerts;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return false;
    }

}
