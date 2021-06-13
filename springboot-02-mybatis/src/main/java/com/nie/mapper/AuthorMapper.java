package com.nie.mapper;

import com.nie.pojo.Author;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AuthorMapper {

    int queryAuthorNumber();

    List<Author> queryAuthorList();

    Author queryAuthorById(int id);

    int createAuthor(Author author);

    int updateAuthor(Author author);

    int deleteAuthor(int id);
}
