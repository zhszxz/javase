package com.bistu.spring6.tx;

import com.bistu.spring6.tx.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.bistu.spring6.tx.controller.BookController;

public class testAnno {
    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bean = context.getBean(BookController.class);
        Integer[] ids = {1, 2};
        bean.checkOut(ids, 1);
    }
}
