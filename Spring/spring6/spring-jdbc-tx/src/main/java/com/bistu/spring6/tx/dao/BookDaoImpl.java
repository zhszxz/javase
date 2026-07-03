package com.bistu.spring6.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer selectBookPriceById(int bookId) {
        String sql = "select price from t_book where book_id=?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return price;
    }

    @Override
    public void updateStock(int bookId) {
        String sql = "update t_book set stock=stock-1 where book_id=?";
        jdbcTemplate.update(sql, bookId);
    }

    @Override
    public void updateUserBalance(int userId, Integer price) {
        String sql = "update t_user set balance=balance-? where user_id =?";
        jdbcTemplate.update(sql, price, userId);
    }
}
