package com.test.mapper;

import com.test.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {
    @Insert("insert into db_book(title,description) values(#{title},#{description})")
    int insertBook(Book book);

    @Select("select * from db_book")
    List<Book> selectAllBook();
}
