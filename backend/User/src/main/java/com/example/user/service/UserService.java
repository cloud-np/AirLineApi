package com.example.user.service;

import com.example.user.model.User;
import com.example.user.reposity.UserRepository;
import jakarta.annotation.PostConstruct;
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
        return userRepository.save(user);
    }

    public User findUserById(Long userId){
        log.info("Inside UserService: findUserById");
        return userRepository.findByUserId(userId);
    }

    public User findByEmail(String email){
        log.info("Inside UserService: findUserById");
        return userRepository.findByEmail(email);
    }

    @PostConstruct
    public void initEntities(){
        userRepository.save(new User((long)1, "Bob", "Dylan", "bobdylan@gmail.com", "1234", null, null, 0));
        userRepository.save(new User((long)2, "Maria", "Depeak", "maria@yahoo.com", "1234", null, null, 0));
        userRepository.save(new User((long)3, "Nick", "Servi", "nick17@gmail.com", "1234", "greek", "DK-9381", 37));
        userRepository.save(new User((long)4, "George", "Menton", "george91@yahoo.com", "1234", "greek", "DK-9381", 26));
    }
}
