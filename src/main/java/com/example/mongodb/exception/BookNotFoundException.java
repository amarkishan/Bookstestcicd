package com.example.mongodb.exception;

public class BookNotFoundException extends RuntimeException
{
    public BookNotFoundException(int id)
    {
        super("Book not found with id:"+id);
    }

}
