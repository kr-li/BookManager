package org.example.service.impl;

import org.example.dao.IBookDao;
import org.example.pojo.Book;
import org.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Override
    public int addBook(Book books) {
        bookDao.addBook(books);
        return 0;
    }

    @Override
    public int deleteBookByID(int id) {
        bookDao.deleteBookByID(id);
        return 0;
    }

    @Override
    public int updateBook(Book books) {
        bookDao.updateBook(books);
        return 0;
    }

    @Override
    public Book queryBookByID(int id) {
       Book book = bookDao.queryBookByID(id);
        return book;
    }

    @Override
    public List<Book> queryAllBook() {
        List<Book> books = bookDao.queryAllBook();
        return books;
    }
}
