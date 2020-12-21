package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IEmpMapper;
import com.study.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServices {
    @Autowired
    IEmpMapper mapper;

    public PageInfo<Emp> selectPage(Integer no, Integer size) {
        System.out.println("分页查询方法");
        PageHelper.startPage(no, size);
        List<Emp> list = mapper.selectall();
        PageInfo<Emp> info = new PageInfo<>(list);
        return info;
    }
}
