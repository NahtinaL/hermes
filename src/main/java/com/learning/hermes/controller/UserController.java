package com.learning.hermes.controller;

import com.learning.hermes.services.UserService;
import com.learning.hermes.shared.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {
        UserDto userTest = new UserDto();
        userTest.setFirstName("BohdanTest");
        userTest.setLastName("Bochulia");
        userTest.setPassword("nonEcriptedpassword");
        userTest.setPhoneNumber("8888567844444");
        userTest.setType("creator");
        userTest.setDepartmentId(1);

        userService.createUser(userTest);
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
