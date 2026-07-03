package com.bistu.spring6.xmltx;

import com.bistu.spring6.tx.service.BookService;
import com.bistu.spring6.tx.service.checkOutService;
import com.bistu.spring6.xmltx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans-xml.xml")
public class testBuyBook {
    @Autowired
    private BookController bookController;

    @Test
    public void test() {
        bookController.buyBook(1,2);
    }
}
