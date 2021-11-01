package com.tattle.chat_server.controllers;

import com.tattle.chat_server.services.UserService;
import com.tattle.chat_server.dtos.user.UserRequest;
import com.tattle.chat_server.dtos.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest req){
        return userService.createUser(req);
    }

    @GetMapping
    public UserResponse getUsers(@RequestParam(value = "user_id", required = false) Integer userId,
                                 @RequestParam(value = "user_name", required = false) String userName){
        return userService.getUsers(userId, userName);
    }

    @DeleteMapping
    public UserResponse deleteUser(@RequestBody UserRequest req){
        return userService.deleteUserById(req);
    }

    @PutMapping
    public UserResponse updateUser(@RequestBody UserRequest req){
        return userService.updateUser(req);
    }

}
