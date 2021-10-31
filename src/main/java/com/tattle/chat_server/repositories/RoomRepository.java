package com.tattle.chat_server.repositories;

import com.tattle.chat_server.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = "select * from room", nativeQuery = true)
    List<Room> getAllRooms();

    @Query(value = "select * from room where name = :roomName", nativeQuery = true)
    List<Room> getRoomsByName(String roomName);

    @Query(value = "delete from room where id = :roomId returning *", nativeQuery = true)
    Room deleteRoom(Integer roomId);

    @Query(value = "update room set name = :roomName where id = :roomId", nativeQuery = true)
    Room updateRoomName(Integer roomId, String roomName);

}
