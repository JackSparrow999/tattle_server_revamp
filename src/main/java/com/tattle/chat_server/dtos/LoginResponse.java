package com.tattle.chat_server.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class LoginResponse {

    Boolean success;

    Boolean loggedIn;

}
