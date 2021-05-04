package org.example.service;

import org.example.pojo.Book;

import java.util.List;

public interface IBookService {
    //增加一个Books
    int addBook(Book books);

    //根据id删除Books
    int deleteBookByID(int id);

    //更新Books
    int updateBook(Book books);

    //根据id查询Book
    Book queryBookByID(int id);

    //查看全部的Book
    List<Book> queryAllBook();
}
