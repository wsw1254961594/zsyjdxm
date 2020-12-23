package com.study.model.mdao;

import com.study.pojo.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 19:14
 */
@Mapper
@Repository
public interface IBorrowMapper {
    /*查询资产借用表*/
    List<Borrow> selectBorrowAll();

    /*高级查询根据 名称 归还日期 价格来进行查询*/
    List<Borrow> selectsBorrow(@Param("bname") String bname,@Param("bget")String bget,@Param("bvalue")String bvalue);
}
