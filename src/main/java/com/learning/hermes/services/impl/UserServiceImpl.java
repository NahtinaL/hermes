package com.learning.hermes.services.impl;

import com.learning.hermes.persistance.entities.UserEntity;
import com.learning.hermes.repository.UserRepository;
import com.learning.hermes.services.UserService;
import com.learning.hermes.shared.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {

        /**
         * 1. Замінити BeanUtils на створення об'єкту через білдер,
         * 2. Передавати ID департменту у реквесті
         * 3. Розібратись і додати підсолювання паролю
         */

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(returnValue, storedUserDetails);

        return returnValue;
    }
}
