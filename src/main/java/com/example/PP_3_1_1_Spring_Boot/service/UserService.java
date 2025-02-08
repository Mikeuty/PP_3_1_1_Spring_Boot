package com.example.PP_3_1_1_Spring_Boot.service;

import com.example.PP_3_1_1_Spring_Boot.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    void saveUser(User user);


    void removeUserById(long id);


    List<User> getAllUsers();


    User getUserById(long id);
}
