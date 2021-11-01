package com.tattle.chat_server.services;

import com.tattle.chat_server.dtos.membership.MembershipRequest;
import com.tattle.chat_server.dtos.membership.MembershipResponse;
import com.tattle.chat_server.dtos.membership.RoomMemberSummary;
import com.tattle.chat_server.dtos.membership.UserMemberSummary;
import com.tattle.chat_server.models.Membership;
import com.tattle.chat_server.models.Room;
import com.tattle.chat_server.models.User;
import com.tattle.chat_server.repositories.MembershipRepository;
import com.tattle.chat_server.repositories.RoomRepository;
import com.tattle.chat_server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MembershipService {

    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoomRepository roomRepository;

    public MembershipResponse createMember(MembershipRequest req){

        User user = null;
        Room room = null;

        try{
            user = userRepository.getById(req.getUserId());
            room = roomRepository.getById(req.getRoomId());
        }
        catch (Exception ex){
            return new MembershipResponse(false, "Entity not found!");
        }

        if(!membershipRepository.getMembershipByUserAndRoom(req.getUserId(), req.getRoomId()).isEmpty())
            return new MembershipResponse(true, "User already a member");

        membershipRepository.save(new Membership(user, room));

        return new MembershipResponse(true, "User added to room");
    }

    public MembershipResponse getRelations(Integer userId, Integer roomId){
        User user = null;
        Room room = null;

        try {
            if(userId != null)
                user = userRepository.getById(userId);
            if(roomId != null)
                room = roomRepository.getById(roomId);
        }
        catch (Exception ex){
            return new MembershipResponse(false, "Entity not found!");
        }

        if(userId != null){
            List<RoomMemberSummary> rooms = membershipRepository.findRoomsByUser(userId)
                    .stream().map(r -> {
                        return new RoomMemberSummary((Integer)r[0], (String)r[1]);
                    })
                    .collect(Collectors.toList());

            return new MembershipResponse(true, null, rooms);
        }
        else if(roomId != null){
            List<UserMemberSummary> users = membershipRepository.findUserByRoom(roomId)
                    .stream().map(u -> new UserMemberSummary((Integer)u[0], (String)u[1]))
                    .collect(Collectors.toList());

            return new MembershipResponse(true, users, null);
        }

        return new MembershipResponse(false, "Invalid request!");
    }

    public MembershipResponse deleteMembership(MembershipRequest req){
        membershipRepository.deleteMembership(req.getUserId(), req.getRoomId());
        return new MembershipResponse(true, "Membership deleted");
    }
}
