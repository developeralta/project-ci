package com.developeralta.banca_mifel.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.developeralta.banca_mifel.mapper.UserMapper;
import com.developeralta.banca_mifel.model.dto.UserRequest;
import com.developeralta.banca_mifel.model.entity.User;
import com.developeralta.banca_mifel.repository.UserRepository;

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
