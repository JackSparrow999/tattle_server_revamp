package com.tattle.chat_server.controllers;

import com.tattle.chat_server.dtos.membership.MembershipRequest;
import com.tattle.chat_server.dtos.membership.MembershipResponse;
import com.tattle.chat_server.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/add_user")
public class MembershipController {

    @Autowired
    MembershipService membershipService;

    @PostMapping
    public MembershipResponse createMembership(@RequestBody MembershipRequest req){
        return membershipService.createMember(req);
    }

    @GetMapping
    public MembershipResponse getMembers(@RequestParam("user_id") Integer userId,
                                         @RequestParam("room_id") Integer roomId){
        return membershipService.getRelations(userId, roomId);
    }

    @DeleteMapping
    public MembershipResponse deleteMembership(@RequestBody MembershipRequest req){
        return membershipService.deleteMembership(req);
    }

}
