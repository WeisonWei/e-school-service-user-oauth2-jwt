package com.es.user.jwt.service;

import com.es.user.jwt.entity.User;
import com.es.user.jwt.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
    }

}
