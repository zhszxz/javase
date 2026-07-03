package com.bistu.spring6.xmltx.controller;

import com.bistu.spring6.tx.service.checkOutService;
import com.bistu.spring6.xmltx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    public void buyBook(int userId, int bookId) {
        bookService.buyBook(userId, bookId);
    }
}
