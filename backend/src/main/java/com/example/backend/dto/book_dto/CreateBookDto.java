package com.example.backend.dto.book_dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateBookDto {
    private Long id;
    @NotNull
    @Size(min = 4 , max = 14)
    private String title;
    @NotNull
    @Size(min = 8 , max = 100)
    private String description;
    @NotNull
    private Long userId;
}
