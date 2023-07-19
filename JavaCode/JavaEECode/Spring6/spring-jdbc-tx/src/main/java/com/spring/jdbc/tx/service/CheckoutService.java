package com.spring.jdbc.tx.service;

public interface CheckoutService {
    //买多本书的方法
    void checkout(Integer[] bookIds, Integer userId);
}
