package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.Gruppe;
import com.redbonesolutions.highline.repository.GruppeRepository;
import com.redbonesolutions.highline.repository.UserRepository;
import com.redbonesolutions.highline.utility.HighlineUtility;

@Service
public class GruppeService {

    @Autowired
    private GruppeRepository gruppeRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Gruppe> findAll() {

        return gruppeRepository.findAll();
    }

    public Gruppe add(Gruppe g) {
        g.setDate_created(HighlineUtility.getCurrentDate());
        g.setLast_updated(HighlineUtility.getLastModified());
        return gruppeRepository.save(g);
    }

    public Gruppe save(Gruppe g) {
        g.setLast_updated(HighlineUtility.getLastModified());
        return gruppeRepository.save(g);
    }

    public void delete(Gruppe g) {
        gruppeRepository.delete(g);
    }

    public Gruppe findOne(long id) {

        Gruppe gruppe =gruppeRepository.findOne(id);
        gruppe.setMembers(userRepository.getUsersInGruppe(id));
        return gruppe;
    }

    public List<Gruppe> findAllByUser(Long id) {

        List<Gruppe> gruppes = gruppeRepository.findAllByUser(id);

        for (Gruppe gruppe : gruppes) {
            gruppe.setMembers(userRepository.getUsersInGruppe(gruppe.getId()));
        }

        return gruppes;
    }

}
