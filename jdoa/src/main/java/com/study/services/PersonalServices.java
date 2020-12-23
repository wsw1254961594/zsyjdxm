package com.study.services;

import com.study.model.jdao.PersonalDAO;
import com.study.pojo.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalServices {
    @Autowired
    PersonalDAO dao;

    public int doInsert(Personal personal){
        try{
            dao.save(personal);
            return 1;
        }catch (Exception e){
            return -1;
        }
    }
}
