package com.nie.mapper;

import com.nie.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    int queryBookNumber();

    List<Book> queryBookList();

    Book queryBookById(int id);

    int createBook(Book book);

    int updateBook(Book book);

    int deleteBook(int id);
}
