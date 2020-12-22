package com.study.services;

import com.study.model.mdao.IJobmsgMapper;
import com.study.pojo.Dept;
import com.study.pojo.Jobmsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobmsgService {
    @Autowired
    IJobmsgMapper mapper;

    public List<Dept> selectbydeptno(Integer deptno){
        List<Dept> list=mapper.selectbydeptno(deptno);
        return list;
    }

    public Jobmsg selectByjmid(Integer jmid){
        Jobmsg jobmsg=mapper.selectByjmid(jmid);
        return jobmsg;
    }
}
