package ru.lkv512.rest.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import ru.lkv512.rest.model.Book;
import ru.lkv512.rest.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/rest/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(value = "Создание книги", notes = "Некторые заметки о создании книги", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Книга создана"),
            @ApiResponse(code = -1, message = "Ошибка №1"),
            @ApiResponse(code = 10, message = "Ошибка №2")
    })
    @GetMapping("/create")
    public Book create(
            @ApiParam("Название книги")  @RequestParam String name,
            @ApiParam("Автор") @RequestParam String author,
            @ApiParam("ISBN") @RequestParam String isbn,
            @ApiParam("Год выпуска") @RequestParam int year){
        return bookService.create(name, author, isbn, year);
    }

    @GetMapping()
    public Book getBook(@RequestParam String isbn){
        return bookService.getByIsbn(isbn);
    }

    @GetMapping(value = "/getAll")
    public List<Book> getBooks(){
        return bookService.getAll();
    }

    @GetMapping(value = "/update")
    public Book update(@RequestParam String name, @RequestParam String author, @RequestParam String isbn, @RequestParam int year){
        return bookService.update(name, author, isbn, year);
    }
    @GetMapping(value = "/delete")
    public void delete(@RequestParam String isbn){
        bookService.delete(isbn);
    }

    @GetMapping(value = "/deleteAll")
    public void deleteAll(){
        bookService.deleteAll();
    }
}
