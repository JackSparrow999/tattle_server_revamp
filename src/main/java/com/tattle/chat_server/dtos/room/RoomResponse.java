package com.tattle.chat_server.dtos.room;

import com.tattle.chat_server.models.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class RoomResponse {

    Boolean success;

    Integer roomId;

    String message;

    String roomName;

    List<RoomSummary> rooms;

    public RoomResponse(Room room){
        this.success = true;
        this.roomId = room.getId();
    }

    public RoomResponse(Boolean success, List<RoomSummary> rooms){
        this.setSuccess(success);
        this.setRooms(rooms);
    }

    public RoomResponse(Boolean success, String message){
        this.setSuccess(success);
        this.setMessage(message);
    }

}
