package com.tattle.chat_server.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
//user is a reserved keyword. can't use as table name in psql
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    String userName;

    String password;

    //user refers to variable name in Membership->user not the table name
    @OneToMany(mappedBy = "user")
    Set<Membership> memberships;

}
