package com.tattle.chat_server.repositories;

import com.tattle.chat_server.models.Membership;
import com.tattle.chat_server.models.Room;
import com.tattle.chat_server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {

    @Query(value = "select * from membership where user_id = :userId and room_id = :roomId", nativeQuery = true)
    List<Membership> getMembershipByUserAndRoom(Integer userId, Integer roomId);

    @Query(value = "select room.id as id, room.name as name from room join membership on room.id = membership.room_id where membership.user_id = :userId", nativeQuery = true)
    List<Room> findRoomsByUser(Integer userId);

    @Query(value = "select users.id as id, users.user_name as user_name, users.password as password from users join membership on users.id = membership.user_id where membership.room_id = :roomId", nativeQuery = true)
    List<User> findUserByRoom(Integer roomId);

    @Query(value = "delete from membership where user_id = :userId and room_id = :roomId returning *", nativeQuery = true)
    Membership deleteMembership(Integer userId, Integer roomId);

}
