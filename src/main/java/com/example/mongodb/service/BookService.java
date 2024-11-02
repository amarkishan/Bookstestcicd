package com.example.mongodb.service;

import com.example.mongodb.entity.Books; // Your custom Books entity
import com.example.mongodb.exception.BookNotFoundException;
import com.example.mongodb.repository.BookMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    @Autowired
    private BookMongoRepository bookRepository;

    public List<Books> getAllBooks()
    {
            List<Books> bookList = new ArrayList<>();
             bookRepository.findAll().forEach(bookList::add);
             return bookList;
    }
    public Books addBook(Books book)
    {
        return bookRepository.save(book);
    }

   public Optional<Books> getBookById(int id)
   {
       if(bookRepository.existsById(id))
       {
           return bookRepository.findById(id);
       }
      throw  new BookNotFoundException(id);
   }

   public boolean deleteBook(int id)
   {
           if(bookRepository.existsById(id))
           {
               bookRepository.deleteById(id);
               return  true;
           }
           throw  new BookNotFoundException(id);


   }

   public Books update(Books book)
   {

       if(bookRepository.existsById(book.getBookid()))
       {
               return bookRepository.save(book);
       }
       throw new BookNotFoundException(book.getBookid());

   }


}
