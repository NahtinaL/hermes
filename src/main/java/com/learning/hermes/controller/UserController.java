package com.learning.hermes.controller;

import com.learning.hermes.model.request.UserDetailRequest;
import com.learning.hermes.model.request.UserLoginRequest;
import com.learning.hermes.model.response.UserDetailsResponse;
import com.learning.hermes.services.LoginService;
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
        return "get User was called";
    }

    @PostMapping
    public UserDetailsResponse createUser(@RequestBody UserDetailRequest requestBody) {
        UserDto userDetails = UserDto.builder()
                .firstName(requestBody.getFirstName())
                .lastName(requestBody.getLastName())
                .phoneNumber(requestBody.getPhoneNumber())
                .password(requestBody.getPassword())
                .departmentId(Integer.parseInt(requestBody.getDepartmentId()))
                .build();

        userService.createUser(userDetails);
        UserDetailsResponse response = UserDetailsResponse.builder()
                .firstName(userDetails.getFirstName())
                .lastName(userDetails.getLastName())
                .phoneNumber(userDetails.getPhoneNumber())
                .build();
        return response;
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
