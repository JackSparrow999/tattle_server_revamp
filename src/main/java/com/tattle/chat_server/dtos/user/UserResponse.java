package com.tattle.chat_server.dtos.user;

import com.tattle.chat_server.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserResponse {

    Boolean success;

    Integer userId;

    List<UserSummary> users;

    String message;

    public UserResponse(User user){
        this.success = true;
        this.userId = user.getId();
    }

    public UserResponse(Boolean success, String message){
        this.success = success;
        this.message = message;
    }
}
