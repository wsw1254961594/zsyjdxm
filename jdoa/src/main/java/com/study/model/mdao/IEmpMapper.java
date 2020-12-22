package com.study.model.mdao;

import com.study.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface IEmpMapper {
    List<Emp> selectall();

    Emp selectByeid(Integer eid);

    int insert(Emp emp);

    List<Emp> selectmohu(@Param("ename") String ename,
                         @Param("ephone") String ephone,
                         @Param("sex") String sex,
                         @Param("time1")String time1,
                         @Param("time2") String time2
                         );
}