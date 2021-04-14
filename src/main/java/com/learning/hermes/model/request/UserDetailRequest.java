package com.learning.hermes.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDetailRequest {

    @NotNull
    @Size(min=2, max=40)
    private String firstName;

    @NotNull
    @Size(min=2, max=40)
    private String lastName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String password;

    @NotNull
    private String departmentId;

}
