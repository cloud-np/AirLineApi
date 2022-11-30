package dev.cloud.userservice.service;

import dev.cloud.userservice.model.User;
import dev.cloud.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public UserService() {}

    public User createUser (User user) {
        System.out.println("inside createAccount in AccountService");
        return userRepository.save(user);
    }
}