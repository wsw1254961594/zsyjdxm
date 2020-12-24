package com.study.services;

import com.study.model.mdao.IpositiveMapper;
import com.study.pojo.Emp;
import com.study.pojo.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositiveServices {
    @Autowired
    IpositiveMapper mapper;

    //新增转正信息
    public Integer doinsert(Positive positive){
        try {
            return mapper.insert(positive);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Integer selectmax(){
        Integer list=mapper.selectmax();
        return list;
    }
}
