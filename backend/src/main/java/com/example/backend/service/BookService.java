package com.example.backend.service;
import org.springframework.stereotype.Service;

import com.example.backend.repositories.BookRepository;
import com.example.backend.repositories.UserRepository;

import java.util.List;

import com.example.backend.dto.book_dto.CreateBookDto;
import com.example.backend.dto.book_dto.UpdateBookDto;
import com.example.backend.entities.Book;
import com.example.backend.entities.User;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    
    public BookService(BookRepository bookRepository , UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }
    

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book createBook(CreateBookDto createBookDto) {
        // First check if user exists
        User user = userRepository.findById(createBookDto.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + createBookDto.getUserId()));
                    
        // Create and persist the book
        Book book = Book.builder()
            .title(createBookDto.getTitle())
            .description(createBookDto.getDescription())
            .user(user)
            .build();

        // Save the book
        return bookRepository.saveAndFlush(book);
    }


    public Book updateBook(UpdateBookDto updateBookDto,Long bookId){
        Book book = bookRepository.findById(bookId).get();
        book.setTitle(updateBookDto.getTitle());
        book.setDescription(updateBookDto.getDescription());
        return bookRepository.save(book);
    }

    public void removeBook(Long bookId){
        bookRepository.deleteById(bookId);
    }
}
