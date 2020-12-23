package com.study.model.mdao;

import com.study.pojo.Dept;
import com.study.pojo.Jobmsg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IJobmsgMapper {
    List<Dept> selectbydeptno(Integer deptno);

    Jobmsg selectByjmid(Integer jmid);
}
