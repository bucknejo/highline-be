package com.redbonesolutions.highline.service;

import com.redbonesolutions.highline.domain.Activity;
import com.redbonesolutions.highline.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getActivitiesByUserId(Long user_id) {
        return activityRepository.getActivitiesByUserId(user_id);
    }


    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Activity findOne(Long id) {
        return activityRepository.findOne(id);
    }

    public Activity add(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    public void delete(Activity activity) {
        activityRepository.delete(activity);
    }
}
