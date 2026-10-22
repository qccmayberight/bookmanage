-- 图书管理系统数据库初始化脚本
create database if not exists `book-manage` default character set utf8mb4 collate utf8mb4_general_ci;
use `book-manage`;

create table if not exists db_student (
    sid    int primary key auto_increment comment '学生ID',
    name   varchar(50) not null comment '姓名',
    gender varchar(10) not null comment '性别',
    age    int         not null comment '年龄'
);

create table if not exists db_book (
    bid         int primary key auto_increment comment '书籍ID',
    title       varchar(100) not null comment '书名',
    description varchar(500) comment '简介'
);

create table if not exists db_borrow (
    sid int not null comment '学生ID',
    bid int not null comment '书籍ID',
    primary key (sid, bid),
    foreign key (sid) references db_student (sid),
    foreign key (bid) references db_book (bid)
);
