package com.study.services;

import com.study.model.mdao.IDeptMapper;
import com.study.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServices {
    @Autowired
    IDeptMapper mapper;

    public List<Dept> selectall(){
        List<Dept> list=mapper.selectall();
        return list;
    }

}
