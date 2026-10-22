package com.test.util;

import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.function.Consumer;


@Log
public class SqlUtil {
    private static SqlSessionFactory factory;   // ← 放到类级别
    static {
        try {
            factory = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new IllegalStateException("MyBatis 初始化失败: " + e.getMessage(), e);
        }
    }
//    public static SqlSession openSession() {
//        sqlSession= factory.openSession(true);
//        return sqlSession;
//    }
public static <T> void doSqlWork(Class<T> mapperClass, Consumer<T> consumer) {
    SqlSession session = null;
    try {
        session = factory.openSession();   // 取新的 session，别用静态单例
        T mapper = session.getMapper(mapperClass);
        consumer.accept(mapper);
        session.commit();                  // 关键：手动提交事务
    } catch (Exception e) {
        if (session != null) session.rollback();
        log.warning("数据库操作失败: " + e.getMessage());
    } finally {
        if (session != null) session.close();
    }
}
}
