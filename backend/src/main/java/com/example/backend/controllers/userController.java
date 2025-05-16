package com.example.backend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.backend.entities.User;
import com.example.backend.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.backend.dto.user_dto.userDto;
import org.modelmapper.ModelMapper;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class userController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public userController(UserService userService, ModelMapper modelMapper){
        this.userService = userService;
        this.modelMapper = modelMapper;
    }
    @RequestMapping("/all")
    public List<userDto> getAll(){
        List<User> users = userService.findAll();
        return users.stream()
                    .map(user -> modelMapper.map(user, userDto.class))
                    .collect(Collectors.toList());
    }
    
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody userDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User createdUser = userService.createUser(user);
        userDto responseUser = modelMapper.map(createdUser,userDto.class);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "User created successfully");
        response.put("user", responseUser);
        return ResponseEntity.ok(response);
    }
}
