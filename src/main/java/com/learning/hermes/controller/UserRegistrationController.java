package com.learning.hermes.controller;

import com.learning.hermes.exceptions.UserException;
import com.learning.hermes.model.request.UserDetailRequest;
import com.learning.hermes.model.response.ErrorMessages;
import com.learning.hermes.model.response.UserDetailsResponse;
import com.learning.hermes.services.UserService;
import com.learning.hermes.shared.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/registration")
@Validated
public class UserRegistrationController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {
        return "get User was called";
    }

    @PostMapping
    public ResponseEntity<UserDetailsResponse> userRegistration(@Valid @RequestBody UserDetailRequest requestBody,
                                                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new UserException(HttpStatus.BAD_REQUEST, ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
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
