package com.bistu.spring6.tx.service;

import com.bistu.spring6.tx.dao.BookDao;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional(propagation = Propagation.REQUIRED)//默认传播行为，当前有事务就用当前事务，没有则新建事务
@Transactional(propagation = Propagation.REQUIRES_NEW)//不管当前有没有事务，都会新建事务，之前事务会被挂起
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    //开启事务
    //@Transactional(readOnly = true)//事务属性：只读
    //@Transactional(timeout= 5)//事务属性：超时
    //@Transactional(isolation = Isolation.DEFAULT)//事务属性：隔离级别
    @Override
    public void buyBook(int userId, int bookId) {
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        Integer price = bookDao.selectBookPriceById(bookId);
        bookDao.updateStock(bookId);
        bookDao.updateUserBalance(userId, price);
    }
}
