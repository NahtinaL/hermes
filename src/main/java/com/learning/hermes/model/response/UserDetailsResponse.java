package com.learning.hermes.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDetailsResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
