package ru.lkv512.rest.service;

import org.springframework.stereotype.Service;
import ru.lkv512.rest.model.Book;
import ru.lkv512.rest.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public Book create(String name, String author, String isbn, int year) {
        return bookRepository.save(new Book(name, author, isbn, year));
    }

    public Book update(String name, String author, String isbn, int year) {
        Book book = getByIsbn(isbn);
        book.setName(name);
        book.setAuthor(author);
        book.setYear(year);
        return bookRepository.save(book);
    }

    public void delete(String isbn) {
        bookRepository.delete(getByIsbn(isbn));
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
