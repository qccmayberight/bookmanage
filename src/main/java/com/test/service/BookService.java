package com.test.service;

import com.test.entity.Book;
import com.test.mapper.BookMapper;
import com.test.util.InputUtil;
import com.test.util.SqlUtil;

public class BookService {
        public static void addBook() {
            String title= InputUtil.nextLine("输入需要插入的书籍名称:");

            String description= InputUtil.nextLine("请输入需要插入的书籍简介:");
            Book book = new Book(0,title,description);

            SqlUtil.doSqlWork(BookMapper.class,mapper -> {
                int count = mapper.insertBook(book);
                if(count>0){
                    System.out.println("书籍信息插入成功"+book);
                }else {
                    System.out.println("书籍信息插入失败,联系失败");
                }
            });
        }
}
