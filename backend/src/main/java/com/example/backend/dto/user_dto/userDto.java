package com.example.backend.dto.user_dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class userDto {
    private Long id;
    @NotNull
    @Size(min = 5 , max = 15)
    private String username;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 8 , max = 16)
    private String password;
}
