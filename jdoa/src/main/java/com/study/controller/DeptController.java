package com.study.controller;

import com.study.config.MyResult;
import com.study.pojo.Dept;
import com.study.services.DeptServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/depts")
@CrossOrigin   //跨域访问
public class DeptController {
    @Autowired
    DeptServices ds;

    @RequestMapping("/all")
    public MyResult selectall(){
        System.out.println("1223213");
        List<Dept> list=ds.selectall();
        return MyResult.returnObjs(list);
    }
}
