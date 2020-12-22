package com.study.model.mdao;

import com.study.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IEmpMapper {
    List<Emp> selectall();

    //tianming 查询下拉框所有员工
    List<Emp> selectm();

}