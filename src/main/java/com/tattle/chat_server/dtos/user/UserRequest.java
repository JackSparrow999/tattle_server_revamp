package com.tattle.chat_server.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserRequest {

    Integer id;

    String userName;

    String password;

}
