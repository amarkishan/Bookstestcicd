package com.example.mongodb.repository;

import com.example.mongodb.entity.Books;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMongoRepository extends MongoRepository<Books, Integer>

{


}
