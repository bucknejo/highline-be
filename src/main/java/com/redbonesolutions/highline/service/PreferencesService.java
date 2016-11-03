package com.redbonesolutions.highline.service;

import com.redbonesolutions.highline.domain.Preferences;
import com.redbonesolutions.highline.repository.PreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferencesService {

    @Autowired
    private PreferencesRepository preferencesRepository;

    public List<Preferences> getPreferencesByUser(long user_id) {
        return preferencesRepository.getPreferencesByUser(user_id);
    }

    public List<Preferences> findAll() {return preferencesRepository.findAll(); }

    public Preferences save(Preferences p) { return preferencesRepository.save(p); }

    public void delete(Preferences p) { preferencesRepository.delete(p); }

    public Preferences findOne(long id) { return preferencesRepository.findOne(id); }

}
