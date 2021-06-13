package com.nie.mapper;

import com.nie.pojo.Author;
import com.nie.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class AuthorMapperTest {

    @Autowired
    private AuthorMapper authorMapper;

    @Test
    public void queryAuthorNumberTest(){
        int authorNumber = authorMapper.queryAuthorNumber();
        System.out.println(authorNumber);
    }

    @Test
    public void queryAuthorListTest(){
        List<Author> authorList = authorMapper.queryAuthorList();
        for(Author author : authorList){
            System.out.println(author);
        }
    }

    @Test
    public void queryAuthorByIdTest(){
        Author author = authorMapper.queryAuthorById(1);
        System.out.println(author);
    }

    @Test
    public void createAuthorTest(){
        int idToCreate = 5;
        queryAuthorNumberTest();
        Author author = new Author(idToCreate,"天蚕土豆",new Date("1989/12/28"),1, new ArrayList<Book>());
        authorMapper.createAuthor(author);
        author = authorMapper.queryAuthorById(idToCreate);
        System.out.println(author);
        queryAuthorNumberTest();
    }

    @Test
    public void updateAuthorTest(){
        int idToUpdate = 5;
        Author author = authorMapper.queryAuthorById(idToUpdate);
        System.out.println(author);
        author.setName("天蚕土豆666");
        authorMapper.updateAuthor(author);
        author = authorMapper.queryAuthorById(idToUpdate);
        System.out.println(author);
    }

    @Test
    public void deleteAuthorTest(){
        int idToDelete = 5;
        Author author = authorMapper.queryAuthorById(idToDelete);
        System.out.println(author);
        authorMapper.deleteAuthor(idToDelete);
        author = authorMapper.queryAuthorById(idToDelete);
        System.out.println(author);
    }

}
