package com.redbonesolutions.highline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbonesolutions.highline.domain.GruppeMember;
import com.redbonesolutions.highline.repository.GruppeMemberRepository;
import com.redbonesolutions.highline.utility.HighlineUtility;

@Service
public class GruppeMemberService {

    @Autowired
    private GruppeMemberRepository gruppeMemberRepository;

    public List<GruppeMember> findAll() {
        return gruppeMemberRepository.findAll();
    }

    public GruppeMember findOne(Long id) {
        return gruppeMemberRepository.findOne(id);
    }

    public GruppeMember findByGruppeIdAndUserId(Long gruppe_id, Long user_id) {
        return gruppeMemberRepository.findByGruppeIdAndUserId(gruppe_id, user_id);
    }

    public List<GruppeMember> findMembersByGruppeId(Long gruppe_id) {
        return gruppeMemberRepository.findMembersByGruppeId(gruppe_id);
    }

    public GruppeMember add(GruppeMember gm) {

        gm.setDate_created(HighlineUtility.getCurrentDate());
        gm.setLast_updated(HighlineUtility.getLastModified());
        gm.setActive(1);

        return gruppeMemberRepository.save(gm);
    }

    public GruppeMember save(GruppeMember gm) {
        return gruppeMemberRepository.save(gm);
    }

    public void delete(GruppeMember gm) {
        gruppeMemberRepository.delete(gm);
    }



}
