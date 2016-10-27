package com.redbonesolutions.highline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redbonesolutions.highline.domain.UserMember;

public interface UserMemberRepository extends JpaRepository<UserMember, Long>{

    @Query(value = "select * from user_members where user_id = :user_id and status = 1 and friend_id not in (select user_id from gruppe_members where gruppe_id = :gruppe_id)", nativeQuery=true)
    List<UserMember> getFriendsNotInGruppe(@Param("user_id") Long user_id, @Param("gruppe_id") Long gruppe_id);

}
