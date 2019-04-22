package ru.lkv512.rest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Book {
    @Id
    private String id;

    private String name;
    private String author;
    private String isbn;
    private int year;

    public Book(String name, String author, String isbn, int year) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", year=" + year +
                '}';
    }
}
