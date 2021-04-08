package com.learning.hermes.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserDetailRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String departmentId;

}
