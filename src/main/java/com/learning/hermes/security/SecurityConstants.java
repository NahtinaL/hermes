package com.learning.hermes.security;

import lombok.Data;

@Data
public class SecurityConstants {

    public static final long EXPIRATION_TIME = 864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGNUP_URL = "/users";
    public static final String TOKEN_SECRET = "kvadratsecret";

}
