package com.nie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private int id;
    private String name;
    private Date dob;
    private int gender; // 0 -> female, 1 -> male;
    private List<Book> bookList;
}
