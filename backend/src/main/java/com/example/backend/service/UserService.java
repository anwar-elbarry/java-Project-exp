package com.example.backend.service;
import com.example.backend.repositories.UserRepository;
import com.example.backend.entities.User;

import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByUserEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void deletUser(Long id){
       userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}