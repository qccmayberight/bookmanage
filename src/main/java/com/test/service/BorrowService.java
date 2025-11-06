package com.test.service;

import com.test.entity.Borrow;
import com.test.mapper.BorrowMapper;
import com.test.util.InputUtil;
import com.test.util.SqlUtil;

public class BorrowService {

    public static void addBorrow() {
        Integer sid = null;
        Integer bid = null;
        while (true) {
            sid = Integer.parseInt(InputUtil.nextLine("请输入学生ID："));
            bid = Integer.parseInt(InputUtil.nextLine("请输入书籍ID："));
            if (sid != null && bid != null) {
                break;
            }
        }
        Borrow borrow = new Borrow(sid, bid);
        SqlUtil.doSqlWork(BorrowMapper.class, mapper -> {
            int count = mapper.insertBorrow(borrow);
            if (count > 0) {
                System.out.println("书籍信息插入成功" + borrow);
            } else {
                System.out.println("书籍信息插入失败");
            }
        });
    }
}
