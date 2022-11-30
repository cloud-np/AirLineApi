package dev.cloud.userservice.controller;

import dev.cloud.userservice.model.User;
import dev.cloud.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/accounts")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }
    //@RequestBody maps the httpRequest body to transfer data onto a Java object (deserializes the JSON into a Java type)
    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        System.out.println("inside createAccount in AccountController");
        System.out.println(user.toString());
        return userService.createUser(user);
    }

}