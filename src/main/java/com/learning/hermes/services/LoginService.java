package com.learning.hermes.services;

import com.learning.hermes.persistance.entities.UserEntity;
import com.learning.hermes.repository.UserRepository;
import com.learning.hermes.utils.Salt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

        boolean result = Arrays.equals(providedSaltedPassword, storedSaltedPassword);

        if(result) {
            System.out.println("Successful login");
            return "succ";
        } else {
            System.out.println("403/401");
            return "403";
        }
    }

}
