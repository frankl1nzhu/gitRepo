package com.spring.jdbc.tx.dao;

public interface BookDao {
    Integer getBookPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateUserBalance(Integer userId, Integer price);
}
