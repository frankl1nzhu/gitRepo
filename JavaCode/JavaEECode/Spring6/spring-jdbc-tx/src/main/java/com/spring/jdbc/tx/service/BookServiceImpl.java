package com.spring.jdbc.tx.service;

import com.spring.jdbc.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW) //事务
/*参数
* readOnly = true       只读，只能查询
* timeout =            超时时间，默认-1永不超时
* norollbackFor  和  norollbackForClassName    不回滚
* isolation =            隔离级别
* propagation =          传播行为：默认required，没有就新建，有就加入
*                                例：101买100和10元的两本书，都不会成功，因为两个行为在一个事务中
*                                requires_new，开启新事务，新事务与之前事务无嵌套关系，之前事务被挂起
*                                例：101买100和10两本书，会买100的，因为两个行为有两个事务
* */
public class BookServiceImpl  implements  BookService{
    @Autowired
    private BookDao bookDao;
    public void buyBook(Integer bookId,Integer userId){
        //模拟超时效果
        /*
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        */
        //根据图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        //更新图书表库存量
        bookDao.updateStock(bookId);
        //更新用户余额
        bookDao.updateUserBalance(userId, price);
    }
}
