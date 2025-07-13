package com.developeralta.banca_mifel.mapper;

import com.developeralta.banca_mifel.model.dto.UserRequest;
import com.developeralta.banca_mifel.model.entity.User;

public class UserMapper {
    public static User toEntity(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());

        return user;
    }
}
