package com.tattle.chat_server.dtos.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class RoomRequest {

    Integer roomId;

    String roomName;

}
