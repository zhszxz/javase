package com.bistu.spring6.xmltx.service;

import com.bistu.spring6.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(int userId, int bookId) {

        Integer price = bookDao.selectBookPriceById(bookId);
        bookDao.updateStock(bookId);
        bookDao.updateUserBalance(userId, price);
    }
}
