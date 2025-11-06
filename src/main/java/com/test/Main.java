package com.test;

import com.test.service.BookService;
import com.test.service.StudentSerice;
import com.test.service.BorrowService;
import com.test.util.InputUtil;
import lombok.AllArgsConstructor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final String prompt = """
         =========== 图书馆录系统 ===========
                  1. 录入学生信息
                  2. 录入书籍信息
                  3. 录入借阅信息
                  4. 查询学生信息
                  5. 查询书籍信息
                  6. 查询借阅情况
                  7. 退出系统
                  请输入上面功能所对应的\n""";


    public static void main(String[] args) {
     while (true) {
         int index = InputUtil.nextInt(prompt);
         if(index<7&&index>=0){
                switch (index){
                    case 1-> StudentSerice.addStudent();
                    case 2-> BookService.addBook();
                    case 3-> BorrowService.addBorrow();
                    case 4 -> {
                        while(true){int

                        }
                    }
                }
         }else{
             break;
         }
     }
        System.out.println("再见,欢迎您下次使用本系统~");
    }
}