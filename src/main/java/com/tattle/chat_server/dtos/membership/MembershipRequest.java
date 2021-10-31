package com.tattle.chat_server.dtos.membership;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class MembershipRequest {

    Integer userId;

    Integer roomId;

}
