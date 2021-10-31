package com.tattle.chat_server.controllers;

import com.tattle.chat_server.dtos.LoginResponse;
import com.tattle.chat_server.dtos.user.UserRequest;
import com.tattle.chat_server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping
    public LoginResponse isLoggedIn(@RequestBody UserRequest req){
        return userService.isLoggedIn(req);
    }

}
