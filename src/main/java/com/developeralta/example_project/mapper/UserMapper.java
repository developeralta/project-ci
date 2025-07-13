package com.developeralta.example_project.mapper;

import com.developeralta.example_project.model.dto.UserRequest;
import com.developeralta.example_project.model.entity.User;

public class UserMapper {
    public static User toEntity(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());

        return user;
    }
}
