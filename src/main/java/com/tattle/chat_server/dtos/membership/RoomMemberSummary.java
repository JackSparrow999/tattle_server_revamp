package com.tattle.chat_server.dtos.membership;

import com.tattle.chat_server.models.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class RoomMemberSummary {

    Integer roomId;

    String roomName;

    public RoomMemberSummary(Room room){
        this.roomId = room.getId();
        this.roomName = room.getName();
    }

}
