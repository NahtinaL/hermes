package com.learning.hermes.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser() {
        return "get User was called";
    }

    @PostMapping
    public String createUser() {
        return "create User was called";
    }

    @PutMapping
    public String updateUser() {
        return "update User was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
