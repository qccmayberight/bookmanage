package com.test.mapper;

import com.test.entity.Borrow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BorrowMapper {
    @Insert("insert into db_borrow(sid,bid) values(#{sid},#{bid})")
    int insertBorrow(Borrow borrow);

    @Select("select b.sid, b.bid, s.name as studentName, k.title as bookTitle " +
            "from db_borrow b " +
            "join db_student s on b.sid = s.sid " +
            "join db_book k on b.bid = k.bid")
    List<Borrow> selectAllBorrow();

    @Delete("delete from db_borrow where sid = #{sid} and bid = #{bid}")
    int deleteBorrow(Borrow borrow);
}
