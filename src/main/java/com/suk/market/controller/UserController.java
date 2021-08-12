package com.suk.market.controller;

import com.suk.market.domain.User;
import com.suk.market.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.findAllUser();
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
         userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteById(id);
    }


}
