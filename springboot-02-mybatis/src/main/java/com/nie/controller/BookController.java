package com.nie.controller;

import com.nie.mapper.BookMapper;
import com.nie.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/books/count")
    public int getBookNumber(){
        int number = bookMapper.queryBookNumber();
        return number;
    }

    @GetMapping("/books")
    public List<Book> getBookList(){
        List<Book> bookList = bookMapper.queryBookList();
        return bookList;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id){
        Book book = bookMapper.queryBookById(id);
        return book;
    }

    @PostMapping("/books")
    public int createBook(Book book){
        int res = bookMapper.createBook(book);
        return res;
    }

    @PatchMapping("/books/{id}")
    public int updateBook(@PathVariable("id") int id, Book book){
        int res = bookMapper.updateBook(book);
        return res;
    }

    @DeleteMapping("/books/{id}")
    public int deleteBook(@PathVariable("id") int id){
        int res = bookMapper.deleteBook(id);
        return res;
    }



}
