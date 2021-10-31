package com.tattle.chat_server.dtos.room;

import com.tattle.chat_server.models.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class RoomSummary {

    Integer id;

    String roomName;

    public RoomSummary(Room room){
        this.id = room.getId();
        this.roomName = room.getName();
    }

}
