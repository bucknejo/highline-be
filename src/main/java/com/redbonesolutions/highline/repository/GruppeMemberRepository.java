package com.redbonesolutions.highline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redbonesolutions.highline.domain.GruppeMember;

import java.util.List;

public interface GruppeMemberRepository extends JpaRepository<GruppeMember, Long>{

    @Query(value = "select * from gruppe_members where gruppe_id = :gruppe_id and user_id = :user_id", nativeQuery=true)
    GruppeMember findByGruppeIdAndUserId(@Param("gruppe_id") Long gruppe_id, @Param("user_id") Long user_id);

    @Query(value = "select * from gruppe_members where gruppe_id = :gruppe_id", nativeQuery=true)
    List<GruppeMember> findMembersByGruppeId(@Param("gruppe_id") Long gruppe_id);

}
