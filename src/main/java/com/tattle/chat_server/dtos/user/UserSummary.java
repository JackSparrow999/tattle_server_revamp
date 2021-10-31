package com.tattle.chat_server.dtos.user;

import com.tattle.chat_server.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserSummary {

    Integer id;

    String userName;

    public UserSummary(User user){
        this.id = user.getId();
        this.userName = user.getUserName();
    }

}
