package com.example.PP_3_1_1_Spring_Boot.service;

import com.example.PP_3_1_1_Spring_Boot.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    //@Transactional
    void createUsersTable();

    //@Transactional
    void dropUsersTable();

    //@Transactional
    void saveUser(User user);

    //@Transactional
    void removeUserById(long id);

   // @Transactional
    List<User> getAllUsers();

   //@Transactional
    void cleanUsersTable();

    //@Transactional
    User getUserById(long id);
}
