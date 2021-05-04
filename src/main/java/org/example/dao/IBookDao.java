package org.example.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookDao {

    //增加一个Books
    @Insert("insert into books (bookName,bookCounts,detail) values (#{bookName}, #{bookCounts}, #{detail})")
    int addBook(Book books);

    //根据id删除Books
    @Delete("delete from books where bookID = #{BookID}")
    int deleteBookByID(int id);

    //更新Books
    @Update("update books set bookName = #{bookName},bookCounts = #{bookCounts},detail = #{detail} where bookID = #{bookID}")
    int updateBook(Book books);

    //根据id查询Book
    @Select("select * from books where bookID = #{BoolID}")
    Book queryBookByID(int id);

    //查看全部的Book
    @Select("select * from books")
    List<Book> queryAllBook();
}
