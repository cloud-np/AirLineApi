package com.example.user.service;

import com.example.user.model.User;
import com.example.user.reposity.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        log.info("Inside UserService: saveUser");
//        return userRepository.save(user);
        return user;
    }

    public User findUserById(Long userId){
        log.info("Inside UserService: findUserById");
        return userRepository.findByUserId(userId);
    }
}
