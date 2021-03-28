package com.learning.hermes.services.impl;

import com.learning.hermes.persistance.entities.Department;
import com.learning.hermes.persistance.entities.UserEntity;
import com.learning.hermes.repository.DepartmentRepository;
import com.learning.hermes.repository.UserRepository;
import com.learning.hermes.services.UserService;
import com.learning.hermes.shared.UserDto;
import com.learning.hermes.utils.Salt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.learning.hermes.utils.Salt.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public UserDto createUser(UserDto user) {

        byte[] byteSalt = null;
        try{
            byteSalt = getSalt();
        } catch (NoSuchAlgorithmException exception) {
            Logger.getLogger(Salt.class.getName()).log(Level.SEVERE, null, exception);
        }

        //Digger the password with Salt
        byte[] digestPassword = getSaltedHash(user.getPassword(), byteSalt);
        String strDigestPassword = toHex(digestPassword);
        String strSalt = toHex(byteSalt);

        Integer departmentId = user.getDepartmentId();
        Department departmentEntity = departmentRepository.findById(departmentId).orElseThrow(RuntimeException::new);

        UserEntity userEntity = UserEntity.builder()
                .type(user.getType())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .password(strDigestPassword)
                .department(departmentEntity)
                .salt(strSalt).build();

        userRepository.save(userEntity);

        return user;
    }
}
