package com.learning.hermes.services;

import com.learning.hermes.persistance.entities.UserEntity;
import com.learning.hermes.repository.UserRepository;
import com.learning.hermes.security.SecurityConstants;
import com.learning.hermes.utils.Salt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public String login (String phoneNumber, String password) throws RuntimeException {

        UserEntity userEntity = userRepository.findByPhoneNumber(phoneNumber);


        String strOriginalSalt = userEntity.getSalt();
        byte[] byteSalt = Salt.fromHex(strOriginalSalt);
        byte[] providedSaltedPassword = Salt.getSaltedHash(password, byteSalt);
        byte[] storedSaltedPassword = Salt.fromHex(userEntity.getPassword());

        if(Arrays.equals(providedSaltedPassword, storedSaltedPassword)) {

            String token = Jwts.builder()
                    .setSubject(userEntity.getFirstName())
                    .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
                    .claim("claim", null)
                    .compact();

            String response = (SecurityConstants.HEADER_STRING + SecurityConstants.TOKEN_PREFIX + token);
            System.out.println(response);
            return response;
        } else {
            System.out.println("403/401");
            return "403";
        }
    }

}
