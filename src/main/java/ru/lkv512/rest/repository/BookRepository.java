package ru.lkv512.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lkv512.rest.model.Book;

public interface BookRepository extends MongoRepository <Book, String>{
    public Book findByIsbn(String isbn);
}
