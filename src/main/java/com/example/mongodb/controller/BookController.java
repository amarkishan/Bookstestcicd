package com.example.mongodb.controller;
import com.example.mongodb.entity.Books;
import com.example.mongodb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api")
@RestController
public class BookController
{
    @Autowired
    BookService bookservice;

    @GetMapping("/allbooks")
    public ResponseEntity<List<Books>> getAllBooks()
    {
        List<Books> b =bookservice.getAllBooks();
        return new ResponseEntity<>(b, HttpStatus.OK);

    }
    @PostMapping("/addbook")
    public HttpEntity<String> addbook(@RequestBody Books books)
    {
        bookservice.addBook(books);
        return new ResponseEntity<>("Book added sucessfully",HttpStatus.CREATED);

    }
    @GetMapping("/bookid/{bookid}")
    public Optional<Books> getBookbyId(@PathVariable("bookid")int bookid)
    {
            return bookservice.getBookById(bookid);
    }

    @DeleteMapping("/bookid/{bookid}")
    public boolean deleteBook(@PathVariable("bookid") int bookid)
    {
          return bookservice.deleteBook(bookid);

    }

    @PutMapping("/updatebook")
    public HttpEntity<String> update(@RequestBody Books books)
    {
        Books b = bookservice.update(books);
        return new ResponseEntity<>("book updated successfully",HttpStatus.OK);

    }







}
