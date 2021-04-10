package com.learning.hermes.controller;

import com.learning.hermes.exceptions.UserCreateException;
import com.learning.hermes.model.request.UserDetailRequest;
import com.learning.hermes.model.response.ErrorMessages;
import com.learning.hermes.model.response.UserDetailsResponse;
import com.learning.hermes.services.UserService;
import com.learning.hermes.shared.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {
        return "get User was called";
    }

    @PostMapping
    public ResponseEntity<UserDetailsResponse> createUser(@RequestBody UserDetailRequest requestBody) {

        try {

            if (requestBody.getFirstName().isEmpty()) {
                throw new UserCreateException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
            }
            if (requestBody.getLastName().isEmpty()) {
                throw new UserCreateException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
            }
            if (requestBody.getPhoneNumber().isEmpty()) {
                throw new UserCreateException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
            }
            if (requestBody.getPassword().isEmpty()) {
                throw new UserCreateException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
            }
            if (requestBody.getDepartmentId().isEmpty()) {
                throw new UserCreateException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
            }
        } catch (NullPointerException exception) {
            throw new UserCreateException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }

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
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.ACCEPTED);
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
