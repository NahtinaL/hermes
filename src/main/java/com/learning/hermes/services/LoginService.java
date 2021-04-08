package com.learning.hermes.services;

import com.learning.hermes.persistance.entities.UserEntity;
import com.learning.hermes.repository.UserRepository;
import com.learning.hermes.security.SecurityConstants;
import com.learning.hermes.utils.Salt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public String login (String phoneNumber, String password) throws RuntimeException {

        UserEntity userEntity = userRepository.findByPhoneNumber(phoneNumber);
        if (userEntity.equals(null)) {
            log.error("User does not exist");
            return null;
        }


        String strOriginalSalt = userEntity.getSalt();
        byte[] byteSalt = Salt.fromHex(strOriginalSalt);
        byte[] providedSaltedPassword = Salt.getSaltedHash(password, byteSalt);
        byte[] storedSaltedPassword = Salt.fromHex(userEntity.getPassword());

        if(Arrays.equals(providedSaltedPassword, storedSaltedPassword)) {

            String token = Jwts.builder()
                    .setSubject(userEntity.getFirstName())
                    .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
                    .claim("USER_TYPE", userEntity.getType())
                    .compact();
            log.info(token);
            return token;
        } else {
           return null;
        }
    }

}
