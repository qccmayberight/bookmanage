package com.test.service;

import com.test.entity.Borrow;
import com.test.mapper.BorrowMapper;
import com.test.util.InputUtil;
import com.test.util.SqlUtil;

import java.util.List;

public class BorrowService {

    public static void addBorrow() {
        int sid = InputUtil.nextInt("请输入学生ID:");
        int bid = InputUtil.nextInt("请输入书籍ID:");
        Borrow borrow = new Borrow(sid, bid, null, null);
        SqlUtil.doSqlWork(BorrowMapper.class, mapper -> {
            int count = mapper.insertBorrow(borrow);
            if (count > 0) {
                System.out.println("借阅信息录入成功: 学生" + sid + " 借阅书籍" + bid);
            } else {
                System.out.println("借阅信息录入失败");
            }
        });
    }

    public static void listBorrow() {
        SqlUtil.doSqlWork(BorrowMapper.class, mapper -> {
            List<Borrow> borrows = mapper.selectAllBorrow();
            if (borrows.isEmpty()) {
                System.err.println("系统中没有任何借阅信息");
                return;
            }
            String format = "%-8s %-8s %-10s %-20s%n";
            System.out.printf(format, "学生ID", "书籍ID", "学生姓名", "书籍名称");
            borrows.forEach(borrow ->
                    System.out.printf(format,
                            borrow.getSid(),
                            borrow.getBid(),
                            borrow.getStudentName(),
                            borrow.getBookTitle())
            );
        });
    }

    public static void returnBook() {
        int sid = InputUtil.nextInt("请输入学生ID:");
        int bid = InputUtil.nextInt("请输入归还的书籍ID:");
        SqlUtil.doSqlWork(BorrowMapper.class, mapper -> {
            int count = mapper.deleteBorrow(new Borrow(sid, bid, null, null));
            if (count > 0) {
                System.out.println("书籍归还成功");
            } else {
                System.out.println("归还失败,未找到对应的借阅记录");
            }
        });
    }
}
