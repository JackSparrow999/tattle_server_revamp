package com.tattle.chat_server.models;

import com.tattle.chat_server.dtos.room.RoomRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    String name;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    Set<Membership> memberships;

    public Room(RoomRequest req){
        this.name = req.getRoomName();
    }

}
