package com.encapsulation;

/**
 * ClassName: BookTest
 * Package: com.encapsulation
 * Description:
 *
 * @Author Yuzhe ZHU
 * @Create 2023/6/9 16:59
 * Version: 1.0
 */
public class BookTest {
    public static void main(String[] args) {
        Book book1 = new Book();

        book1.setBookName("petit");
        System.out.println(book1.getBookName());
        book1.setAuthor("me");
        System.out.println(book1.getAuthor());
    }
}
