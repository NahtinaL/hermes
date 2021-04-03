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
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping
    public String getUser() {
        return "get User was called";
    }

    @PostMapping
    public String login(@RequestBody UserLoginRequest loginRequest) {
        String response = loginService.login(loginRequest.getPhoneNumber(), loginRequest.getPassword());
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
