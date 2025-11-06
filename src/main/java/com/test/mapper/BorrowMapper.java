package com.test.mapper;

import com.test.entity.Borrow;
import org.apache.ibatis.annotations.Insert;

public interface BorrowMapper {
    @Insert("insert into db_borrow(sid,bid)values(#{sid},#{bid})")
    int insertBorrow(Borrow borrow);
}
