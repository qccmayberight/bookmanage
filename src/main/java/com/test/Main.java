package com.test;

import com.test.service.BookService;
import com.test.service.BorrowService;
import com.test.service.StudentService;
import com.test.util.InputUtil;

public class Main {
    private static final String PROMPT = """
             =========== 图书管理系统 ===========
                      1. 录入学生信息
                      2. 录入书籍信息
                      3. 录入借阅信息
                      4. 查询学生信息
                      5. 查询书籍信息
                      6. 查询借阅情况
                      7. 归还书籍
                      8. 退出系统
             请输入上面功能所对应的序号:""";

    public static void main(String[] args) {
        while (true) {
            int index = InputUtil.nextInt(PROMPT);
            switch (index) {
                case 1 -> StudentService.addStudent();
                case 2 -> BookService.addBook();
                case 3 -> BorrowService.addBorrow();
                case 4 -> StudentService.listStudent();
                case 5 -> BookService.listBook();
                case 6 -> BorrowService.listBorrow();
                case 7 -> BorrowService.returnBook();
                case 8 -> {
                    System.out.println("再见,欢迎您下次使用本系统~");
                    return;
                }
                default -> System.out.println("输入有误,请输入 1-8 之间的序号!");
            }
        }
    }
}
