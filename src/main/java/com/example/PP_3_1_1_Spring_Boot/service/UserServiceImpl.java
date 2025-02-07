package com.example.PP_3_1_1_Spring_Boot.service;


import com.example.PP_3_1_1_Spring_Boot.model.User;
import com.example.PP_3_1_1_Spring_Boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, DataSource dataSource) {
        this.userRepository = userRepository;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUserById(long id) {
        userRepository.deleteById(id);
    }

    //Вроде как можно с помощью миграции это сделать, но я пока не умею.
    //Поэтому jdbcTemplate из курса Алишева.
    @Override
    public void createUsersTable() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (\n" +
                "  id BIGINT AUTO_INCREMENT PRIMARY KEY,\n" +
                "  name VARCHAR(50) NOT NULL,\n" +
                "  last_name VARCHAR(50) NOT NULL,\n" +
                "  age TINYINT UNSIGNED NOT NULL\n" +
                ");");
    }

    @Override
    public void dropUsersTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS users");
    }

    @Override
    public void cleanUsersTable() {
        jdbcTemplate.execute("DELETE FROM users");
    }
}
