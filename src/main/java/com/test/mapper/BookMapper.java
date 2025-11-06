package com.test.mapper;

import com.test.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.Insert;


public interface BookMapper {
    @Insert("insert into db_book(title,description)values(#{title},#{description})")
    int insertBook(Book book);
}
