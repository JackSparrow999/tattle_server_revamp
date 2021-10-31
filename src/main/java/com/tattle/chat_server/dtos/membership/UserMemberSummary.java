package com.tattle.chat_server.dtos.membership;

import com.tattle.chat_server.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserMemberSummary {

    Integer userId;

    String userName;

    public UserMemberSummary(User user){
        this.userId = user.getId();
        this.userName = user.getUserName();
    }

}
