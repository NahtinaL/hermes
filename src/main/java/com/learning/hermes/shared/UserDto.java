package com.learning.hermes.shared;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserDto implements Serializable {

    private static final long serialVersionUID = 8L;
    private Integer id;
    private String type;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String encryptedPassword;
    private Integer departmentId;

}
