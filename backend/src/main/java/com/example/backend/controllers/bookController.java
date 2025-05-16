package com.example.backend.controllers;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import com.example.backend.entities.Book;
import com.example.backend.service.BookService;
import com.example.backend.dto.book_dto.CreateBookDto;
import com.example.backend.dto.book_dto.UpdateBookDto;

@RestController
@RequestMapping("api/books")
@CrossOrigin(origins = "http://localhost:4200")
public class bookController {
    
    private final BookService bookService;
    private final ModelMapper modelMapper;
    
    public bookController (BookService bookService,ModelMapper modelMapper){
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UpdateBookDto>> getAll(){
        List<Book> books = bookService.getAll();
        return ResponseEntity.ok(books.stream()
                    .map(book -> modelMapper.map(book, UpdateBookDto.class))
                    .collect(Collectors.toList()));
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String,Object>> createBook(@Valid @RequestBody CreateBookDto createBookDto){
        Book createdBook = bookService.createBook(createBookDto);
        UpdateBookDto responseBook = modelMapper.map(createdBook, UpdateBookDto.class);

        Map<String,Object> response = new HashMap<>();
        response.put("message", "Book created successfully");
        response.put("book", responseBook);
        return ResponseEntity.ok(response);
    }
}
