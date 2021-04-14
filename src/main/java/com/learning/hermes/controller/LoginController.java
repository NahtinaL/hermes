package com.learning.hermes.controller;


import com.learning.hermes.model.request.UserLoginRequest;
import com.learning.hermes.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserLoginRequest loginRequest) {
        String response = loginService.login(loginRequest.getPhoneNumber(), loginRequest.getPassword());
        if (response == null) {
            ResponseEntity.status(401);
        }
        return ResponseEntity.ok(response);
    }

}
