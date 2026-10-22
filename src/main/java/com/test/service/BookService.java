package com.test.service;

import com.test.entity.Book;
import com.test.mapper.BookMapper;
import com.test.util.InputUtil;
import com.test.util.SqlUtil;

import java.util.List;

public class BookService {
    public static void addBook() {
        String title = InputUtil.nextLine("输入需要插入的书籍名称:");

        String description = InputUtil.nextLine("请输入需要插入的书籍简介:");
        Book book = new Book(0, title, description);

        SqlUtil.doSqlWork(BookMapper.class, mapper -> {
            int count = mapper.insertBook(book);
            if (count > 0) {
                System.out.println("书籍信息插入成功" + book);
            } else {
                System.out.println("书籍信息插入失败,请联系管理员");
            }
        });
    }

    public static void listBook() {
        SqlUtil.doSqlWork(BookMapper.class, mapper -> {
            List<Book> books = mapper.selectAllBook();
            if (books.isEmpty()) {
                System.err.println("系统中没有任何书籍信息");
                return;
            }
            String format = "%-6s %-20s %-30s%n";
            System.out.printf(format, "编号", "书名", "简介");
            books.forEach(book ->
                    System.out.printf(format, book.getBid(), book.getTitle(), book.getDescription())
            );
        });
    }
}
