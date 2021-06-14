package com.nie.controller;

import com.nie.mapper.AuthorMapper;
import com.nie.pojo.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorMapper authorMapper;

    @GetMapping("/authors")
    public List<Author> getAuthorList(){
        List<Author> authorList = authorMapper.queryAuthorList();
        return authorList;
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable("id") int id){
        Author author = authorMapper.queryAuthorById(id);
        return author;
    }

    @GetMapping("/authors/count")
    public int getAuthorNumber(){
        int number = authorMapper.queryAuthorNumber();
        return number;
    }

    @PostMapping("/authors")
    public String createAuthor(Author author){
        int res = authorMapper.createAuthor(author);
        String response = "{ \"response code\":" + res + " }";
        return response;
    }

    @PatchMapping("/authors/{id}")
    public String updateAuthor(@PathVariable("id") int id, Author author){
        int res = authorMapper.updateAuthor(author);
        String response = "{ \"response code\":" + res + " }";
        return response;
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthor(@PathVariable("id") int id){
        int res = authorMapper.deleteAuthor(id);
        String response = "{ \"response code\":" + res + " }";
        return response;
    }
}
