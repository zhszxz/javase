package com.bistu.spring6.tx.controller;

import com.bistu.spring6.tx.service.BookService;
import com.bistu.spring6.tx.service.checkOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    /*@Autowired
        private BookService bookService;
        public void buyBook(int userId,int bookId){
            bookService.buyBook(userId,bookId);
        }*/
    @Autowired
    private checkOutService checkOutService;
    public void checkOut(Integer bookIds[],int userId){
        checkOutService.checkout(bookIds,userId);
    }
}
