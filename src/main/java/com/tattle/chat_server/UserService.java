package com.tattle.chat_server;

import com.tattle.chat_server.dtos.user.UserRequest;
import com.tattle.chat_server.dtos.user.UserResponse;
import com.tattle.chat_server.dtos.user.UserSummary;
import com.tattle.chat_server.models.User;
import com.tattle.chat_server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponse createUser(UserRequest req){
        User user = new User(req);
        userRepository.save(user);
        return new UserResponse(user);
    }

    public UserResponse getUsers(UserRequest req){
        UserResponse res = new UserResponse();
        res.setSuccess(false);

        if(req.getUserName()==null && req.getId()==null){
            List<UserSummary> lst = userRepository.getAllUsers().stream().map(x -> new UserSummary(x))
                    .collect(Collectors.toList());
            res.setUsers(lst);
            res.setSuccess(true);
        }
        else if(req.getId() != null){
            List<UserSummary> lst = Arrays.asList(new UserSummary(userRepository.getById(req.getId())));
            res.setUsers(lst);
            res.setSuccess(true);
        }
        else if(req.getUserName() != null){
            List<UserSummary> lst = userRepository.getUsersByName(req.getUserName()).stream().map(x -> new UserSummary(x))
                    .collect(Collectors.toList());
            res.setUsers(lst);
            res.setSuccess(true);
        }

        return res;
    }

    public UserResponse deleteUserById(UserRequest req){
        if(req.getId() == null)
            return new UserResponse(false, "No user_id in request");

        try{
            userRepository.deleteUserById(req.getId());
        }
        catch (Exception ex){
            return new UserResponse(false, "Something went wrong!");
        }

        return new UserResponse(true, "User is successfully deleted");
    }

    public UserResponse updateUser(UserRequest req){
        if(req.getId() == null)
            return new UserResponse(false, "No user id found");

        User user = userRepository.getById(req.getId());

        if(user.getUserName()!=null && user.getUserName().equals(req.getUserName()))
            userRepository.updateUserName(req.getId(), req.getUserName());

        if(user.getPassword()!=null && user.getPassword().equals(req.getPassword()))
            userRepository.updatePassword(req.getId(), req.getPassword());

        return new UserResponse(true, "User data updated");
    }

}
