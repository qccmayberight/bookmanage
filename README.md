# BookManage 图书管理系统

基于 Java + MyBatis + MySQL 的控制台图书管理系统，支持学生、书籍、借阅信息的录入与查询，以及书籍归还。

## 技术栈

- Java 21
- MyBatis 3.5
- MySQL 8.0
- Lombok
- Maven

## 功能列表

1. 录入学生信息
2. 录入书籍信息
3. 录入借阅信息
4. 查询学生信息
5. 查询书籍信息
6. 查询借阅情况（关联显示学生姓名与书籍名称）
7. 归还书籍
8. 退出系统

## 快速开始

### 1. 初始化数据库

```bash
mysql -uroot -p < schema.sql
```

### 2. 配置数据库连接

复制配置模板并填入你自己的数据库账号密码：

```bash
cp src/main/resources/db.properties.example src/main/resources/db.properties
```

`db.properties` 已被 `.gitignore` 忽略，不会被提交到仓库。

### 3. 编译运行

```bash
mvn compile
mvn exec:java -Dexec.mainClass=com.test.Main
```

或在 IDEA 中直接运行 `com.test.Main`。

## 项目结构

```
src/main/java/com/test
├── Main.java            # 程序入口与菜单
├── entity/              # 实体类（Student / Book / Borrow）
├── mapper/              # MyBatis Mapper 接口
├── service/             # 业务逻辑
└── util/                # 输入与数据库工具类
```
