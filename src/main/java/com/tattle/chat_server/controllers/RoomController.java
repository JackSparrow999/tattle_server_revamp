package com.tattle.chat_server.controllers;

import com.tattle.chat_server.dtos.room.RoomRequest;
import com.tattle.chat_server.dtos.room.RoomResponse;
import com.tattle.chat_server.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping
    public RoomResponse createRoom(@RequestBody RoomRequest req){
        return roomService.createRoom(req);
    }

    @GetMapping
    public RoomResponse getRooms(@RequestParam("room_id") Integer roomId,
                                 @RequestParam("room_name") String roomName){
        return roomService.getRoom(roomId, roomName);
    }

    @DeleteMapping
    public RoomResponse deleteRoom(@RequestBody RoomRequest req){
        return roomService.deleteRoom(req);
    }

    @PutMapping
    public RoomResponse updateRoom(@RequestBody RoomRequest req){
        return roomService.updateRoom(req);
    }

}
