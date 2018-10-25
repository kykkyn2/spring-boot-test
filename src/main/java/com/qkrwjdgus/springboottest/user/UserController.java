package com.qkrwjdgus.springboottest.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @PostMapping("/users/create")
    public User createUser(@RequestBody User user) {
        return user;
    }

}
