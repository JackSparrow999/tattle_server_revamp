package com.tattle.chat_server.dtos.membership;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class MembershipResponse {

    Boolean success;

    String message;

    List<RoomMemberSummary> rooms;

    List<UserMemberSummary> users;

    public MembershipResponse(Boolean success, List<UserMemberSummary> users, List<RoomMemberSummary> rooms){
        this.success = success;
        this.rooms = rooms;
        this.users = users;
    }

    public MembershipResponse(Boolean success, String message){
        this.success = success;
        this.message = message;
    }

}
