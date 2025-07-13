package com.developeralta.example_project.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.developeralta.example_project.mapper.UserMapper;
import com.developeralta.example_project.model.dto.UserRequest;
import com.developeralta.example_project.model.entity.User;
import com.developeralta.example_project.repository.UserRepository;

@Component
public class UserInitializer implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<UserRequest> users = List.of(new UserRequest("developeralta", "N4m3M4r10"));

        for (UserRequest userRequest : users) {
            User user = UserMapper.toEntity(userRequest);
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            userRepository.save(user);
        }
    }

}
