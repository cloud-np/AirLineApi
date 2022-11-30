package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test(){
        log.info("testing");
        return "test";
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user){
        log.info("Inside UserController: saveUser");
        return userService.findByEmail(user.getEmail());
    }

    @PostMapping("/register")
    public User saveUser(@RequestBody User user){
        log.info("Inside UserController: saveUser");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId){
        log.info("Inside UserController: findUserById");
        return userService.findUserById(userId);
    }
}
