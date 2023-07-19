package com.sc.spring6.di;

public class Book {
    private String name;
    private String author;

    public Book() {
        System.out.println("无参构造执行了...");
    }

    public Book(String name, String author) {
        System.out.println("有参构造执行了...");
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //通过set注入
        Book book1 = new Book();
        book1.setName("java");
        book1.setAuthor("zhangsan");
        System.out.println(book1);

        //通过构造器注入
        Book book2 = new Book("spring", "lisi");
        System.out.println(book2);
    }
}
