package com.learning.hermes.services.impl;

import com.learning.hermes.persistance.entities.Department;
import com.learning.hermes.persistance.entities.UserEntity;
import com.learning.hermes.repository.DepartmentRepository;
import com.learning.hermes.repository.UserRepository;
import com.learning.hermes.services.UserService;
import com.learning.hermes.shared.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public UserDto createUser(UserDto user) {

        Integer departmentId = user.getDepartmentId();
        Department departmentEntity = departmentRepository.findById(departmentId).orElseThrow(RuntimeException::new);

        UserEntity userEntity = UserEntity.builder()
                .type(user.getType())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .password(user.getPassword())
                .department(departmentEntity).build();

        userRepository.save(userEntity);

        return user;
    }
}
