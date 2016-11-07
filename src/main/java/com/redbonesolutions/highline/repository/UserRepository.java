package com.redbonesolutions.highline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redbonesolutions.highline.domain.User;

public interface UserRepository extends JpaRepository<User, Long>  {

    @Query(value = "select * from user where id in (select user_id from gruppe_members where gruppe_id = :gruppe_id)", nativeQuery=true)
    List<User> getUsersInGruppe(@Param("gruppe_id") Long gruppe_id);

    @Query(value = "select * from user where email = :email", nativeQuery=true)
    User getUserByEmail(@Param("email") String email);

    @Query(value = "select * from user where id not in (select friend_id from user_members where user_id = :user_id) and id != :id", nativeQuery=true)
    List<User> getMembers(@Param("user_id") Long user_id, @Param("id") Long id);

    @Query(value = "select a.*, (select status from user_members where friend_id = a.id) as 'status' from user a where a.id in (select friend_id from user_members where user_id = :user_id)", nativeQuery=true)
    List<Object[]> getFriends(@Param("user_id") Long user_id);

    @Query(value = "select * from user where id in (select friend_id from user_members where user_id = :user_id and status = 1 and friend_id not in (select user_id from gruppe_members where gruppe_id = :gruppe_id))", nativeQuery=true)
    List<User> getFriendsNotInGroup(@Param("user_id") Long user_id, @Param("gruppe_id") Long gruppe_id);

    @Query(value = "select * from user where id in (select friend_id from user_members where user_id = :uid1 and status = 1 and friend_id not in (select user_id from ride_members where ride_id = :rid and user_id != :uid2))", nativeQuery=true)
    List<User> getFriendsNotInRide(@Param("uid1") Long uid1, @Param("rid") Long rid, @Param("uid2") Long uid2);

    @Query(value="select * from user where id in (select user_id from redbone1_highline.ride_members where ride_id = :ride_id and user_id != :user_id)", nativeQuery=true)
    List<User> getRidersByRide(@Param("ride_id") long ride_id, @Param("user_id") long user_id);

}
