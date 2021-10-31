package com.tattle.chat_server.repositories;

import com.tattle.chat_server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from users", nativeQuery = true)
    List<User> getAllUsers();

    @Query(value = "select * from users where user_name = :userName", nativeQuery = true)
    List<User> getUsersByName(String userName);

    @Query(value = "delete from users where id = :id", nativeQuery = true)
    User deleteUserById(Integer id);

    @Query(value = "update users set user_name = :userName where id = :id", nativeQuery = true)
    User updateUserName(Integer id, String userName);

    @Query(value = "update users set password = :password where id = :id", nativeQuery = true)
    User updatePassword(Integer id, String password);

}
