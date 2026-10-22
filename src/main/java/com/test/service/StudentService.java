package com.test.service;

import com.test.entity.Student;

import com.test.mapper.StudentMapper;
import com.test.util.InputUtil;
import com.test.util.SqlUtil;

import java.util.List;

public class StudentService {
    public static void addStudent() {

        String name= InputUtil.nextLine("输入需要插入的学生名字:");

        String gender= InputUtil.nextLine("请输入需要插入学生的性别(男/女):","男","女");

        int age= InputUtil.nextInt("请输入需要插入学生的年龄:");
        Student student=new Student(0,name,gender,age);
        System.out.println(student);
        SqlUtil.doSqlWork(StudentMapper.class,mapper->{
            int count =mapper.insertStudent(student);
            if(count>0){
                System.out.println("用户信息插入成功"+student);
            }else {
                System.out.println("用户信息插入失败,联系失败");
            }
        });
    }
    public static void listStudent() {
        SqlUtil.doSqlWork(StudentMapper.class, mapper -> {
            List<Student> students = mapper.selectAllStudent();
            if (!students.isEmpty()) {
                String format = "%-5s %-6s %-5s %-5s%n";   // %n 是跨平台换行
                System.out.printf(format, "学号", "姓名", "性别", "年龄");
                students.forEach(stu ->
                        System.out.printf(format,
                                stu.getSid(),
                                stu.getName(),
                                stu.getGender(),
                                stu.getAge())
                );
            } else {
                System.err.println("系统中没有任何学生信息");
            }
        });
    }
}
