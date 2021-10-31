package com.tattle.chat_server.services;

import com.tattle.chat_server.dtos.room.RoomRequest;
import com.tattle.chat_server.dtos.room.RoomResponse;
import com.tattle.chat_server.dtos.room.RoomSummary;
import com.tattle.chat_server.models.Room;
import com.tattle.chat_server.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public RoomResponse createRoom(RoomRequest req){
        return new RoomResponse(roomRepository.save(new Room(req)));
    }

    public RoomResponse getRoom(Integer roomId, String roomName){
        RoomResponse res = new RoomResponse();
        res.setSuccess(false);
        res.setMessage("No rooms found!");

        if(roomId == null && roomName == null){
            List<RoomSummary> lst = roomRepository.getAllRooms().stream()
                    .map(r -> new RoomSummary(r))
                    .collect(Collectors.toList());

            res.setSuccess(true);
            res.setRooms(lst);
        }
        else if(roomId != null){
            Room room = roomRepository.getById(roomId);
            res.setRoomId(room.getId());
            res.setRoomName(room.getName());
        }
        else if(roomName != null){
            List<RoomSummary> lst = roomRepository.getRoomsByName(roomName).stream()
                    .map(r -> new RoomSummary(r))
                    .collect(Collectors.toList());

            res.setSuccess(true);
            res.setRooms(lst);
        }

        return res;
    }

    public RoomResponse deleteRoom(RoomRequest req){
        if(req.getRoomId() == null)
            return new RoomResponse(false, "No room id in request");

        Room room = roomRepository.deleteRoom(req.getRoomId());

        return new RoomResponse(room);
    }

    public RoomResponse updateRoom(RoomRequest req){
        if(req.getRoomId() == null)
            return new RoomResponse(false, "No room id in request");

        if(req.getRoomName() != null)
            roomRepository.updateRoomName(req.getRoomId(), req.getRoomName());

        return new RoomResponse(true, "Room updated!");
    }

}
