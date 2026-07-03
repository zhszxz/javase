package com.bistu.spring6.xmltx.dao;

public interface BookDao {
    Integer selectBookPriceById(int bookId);

    void updateStock(int bookId);

    void updateUserBalance(int userId, Integer price);
}
