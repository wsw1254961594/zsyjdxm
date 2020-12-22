package com.study.model.mdao;

import com.study.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IDeptMapper {
    List<Dept> selectall();
}
