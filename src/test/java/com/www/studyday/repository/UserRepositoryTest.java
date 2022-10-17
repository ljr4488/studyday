package com.www.studyday.repository;

import com.www.studyday.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.www.studyday.StudydayApplicationTests;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudydayApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setLoginId("ljr4488");
        user.setPassword("ljr4488");
        user.setName("이주량");
        user.setUserType(1);
        user.setBirth(LocalDateTime.now());
        user.setIsLock(1);
        user.setAddress("서울시 송파구 풍납동");
        user.setCreated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());

        User newUser = userRepository.save(user);
        System.out.println("NewUser : " + newUser);

    }
//    @Test
//    public void read() {
//        Optional<User> user = userRepository.findById(1L);
//
//        user.ifPresent(selectUser -> {
//            System.out.println("user : " + selectUser);
//        });
//    }

    public void update() {

    }

    public void delete() {

    }
}
