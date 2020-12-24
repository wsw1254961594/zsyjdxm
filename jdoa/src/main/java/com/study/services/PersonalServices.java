package com.study.services;

import com.study.model.jdao.PersonalDAO;
import com.study.model.mdao.PersonalMapper;
import com.study.pojo.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalServices {
    @Autowired
    PersonalDAO dao;
    @Autowired
    PersonalMapper mapper;

    public Integer doInsert(String password,Integer empno){
        return  mapper.insert(password,empno);

    }
}
