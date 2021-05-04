package org.example.controller;

import org.example.pojo.Book;
import org.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    // 展示全部的书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        System.out.println("表现层查询所有书籍信息。。");
        List<Book> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    // 跳转到新增书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBookPage(){
        System.out.println("toaddbook方法执行了");
        return "addBook";
    }

    // 增加书籍
    @RequestMapping("/addBook")
    public String addBook(Book book, Model model){
        bookService.addBook(book);
        return "redirect:/book/allBook";
    }

    // 跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Book book = bookService.queryBookByID(id);
        model.addAttribute("book",book);
        return "updateBook";
    }

    // 修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Book book, Model model){
        bookService.updateBook(book);
        // 更新最新的书籍
        Book book1 = bookService.queryBookByID(book.getBookID());
        model.addAttribute("books",book1);
        return "redirect:/book/allBook";
    }

    // 删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deleteBookByID(id);
        return "redirect:/book/allBook";
    }
}
