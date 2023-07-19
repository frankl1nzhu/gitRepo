package com.encapsulation;

/**
 * ClassName: Book
 * Package: com.encapsulation
 * Description:
 *
 * @Author Yuzhe ZHU
 * @Create 2023/6/9 16:53
 * Version: 1.0
 */
public class Book {
    private String bookName;
    private String author;
    private double price;

    public void setBookName(String BN){
        bookName = BN;
    }
    public String getBookName(){
        return bookName;
    }
    public void setAuthor(String ath){
        author = ath;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(String p){
        bookName = p;
    }

}
