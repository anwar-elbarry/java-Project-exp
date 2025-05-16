package com.example.backend.dto.book_dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateBookDto {
    @NotNull
    @Size(min = 4 , max = 14)
    private String title;
    @NotNull
    @Size(min = 8 , max = 100)
    private String description;
}
