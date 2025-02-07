package com.example.PP_3_1_1_Spring_Boot.repository;

import com.example.PP_3_1_1_Spring_Boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
