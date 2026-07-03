package com.bistu.spring6.tx.dao;

public interface BookDao {
    Integer selectBookPriceById(int bookId);

    void updateStock(int bookId);

    void updateUserBalance(int userId, Integer price);
}
