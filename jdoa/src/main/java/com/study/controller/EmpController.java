package com.study.controller;

import com.study.config.MyResult;
import com.study.services.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emps")
@CrossOrigin   //跨域访问
public class EmpController {
    @Autowired
    EmpServices es;

    @RequestMapping("/pages")
    public MyResult selectByPage(@RequestParam("no") Integer no, @RequestParam(value = "size", required = false) Integer size) {
        System.out.println("1111111111");
        Integer pagesize = 5;
        if (size != null) {
            pagesize = size;
        }
        return MyResult.okAndpage(es.selectPage(no, pagesize));
    }
}
