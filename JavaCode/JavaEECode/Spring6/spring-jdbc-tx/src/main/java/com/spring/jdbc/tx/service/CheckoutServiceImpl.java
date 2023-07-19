package com.spring.jdbc.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    //注入bookService
    @Autowired
    private BookService bookService;

    @Transactional
    @Override
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer bookId:bookIds) {
            bookService.buyBook(bookId, userId);
        }
    }
}
