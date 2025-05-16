package com.example.backend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.backend.entities.User;
import com.example.backend.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class userController {
    private final UserService userService;

    public userController(UserService userService){
        this.userService = userService;
    }
    @RequestMapping("/all")
    public List<User> getAll(){
        return userService.findAll();
    }
    
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User created successfully");
        response.put("user", createdUser);
        return ResponseEntity.ok(response);
    }
}
