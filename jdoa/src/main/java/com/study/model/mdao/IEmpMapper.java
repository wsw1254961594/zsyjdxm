package com.study.model.mdao;

import com.study.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IEmpMapper {
    List<Emp> selectall();
}