package com.nie.mapper;

import com.nie.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void queryBookNumber(){
        int numberOfBooks = bookMapper.queryBookNumber();
        System.out.println(numberOfBooks);
    }

    @Test
    public void queryBookListTest(){
        List<Book> bookList = bookMapper.queryBookList();
        for(Book book : bookList){
            System.out.println(book);
        }
    }

    @Test
    public void queryBookByIdTest(){
        Book book = bookMapper.queryBookById(1);
        System.out.println(book);
    }

    @Test
    public void createBookTest(){
        int previousNum = bookMapper.queryBookNumber();

        Book book = new Book();
        book.setName("神印王座");
        book.setDescription("小说讲述一名少年立志加入人类骑士圣殿与魔族抗争，奇迹、诡计不断在他身边上演，最终他凭借自己的努力，登上象征着骑士最高荣耀的神印王座的故事。");
        book.setPublicationDate(new Date("2011/11/20"));
        book.setAuthorId(1);

        bookMapper.createBook(book);
        int currentNum = bookMapper.queryBookNumber();
        System.out.println(currentNum - previousNum);
    }

    @Test
    public void updateBookTest(){
        Book book = bookMapper.queryBookById(1);
        book.setPublicationDate(new Date("2009/5/2"));

        bookMapper.updateBook(book);

        book = bookMapper.queryBookById(1);
        System.out.println(book);
    }

    @Test
    public void deleteBookTest(){
        List<Book> bookList = bookMapper.queryBookList();
        // 选择最后一本书进行删除
        Book bookToDelete = bookList.get(bookList.size()-1);
        int idToDelete = bookToDelete.getId();

        // 再次确认这本书在数据库中存在
        Book book = bookMapper.queryBookById(idToDelete);
        System.out.println(book);

        bookMapper.deleteBook(idToDelete);

        // 尝试在数据库中查询已经被删除的书籍
        book = bookMapper.queryBookById(idToDelete);
        System.out.println(book);

    }


}
