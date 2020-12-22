package com.study.controller;

import com.study.config.MyResult;
import com.study.pojo.Emp;
import com.study.services.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/byeid")
    public MyResult selectByeid(Integer eid){
        Emp emp=es.selectByeid(eid);
        return MyResult.returnObj(emp);
    }

    @RequestMapping("/mohu")
    public MyResult add(@RequestParam(value = "ename",required = false) String ename,
                        @RequestParam(value = "ephone",required = false) String ephone,
                        @RequestParam(value = "sex",required = false) String sex,
                        @RequestParam(value = "ofday[0]",required = false) String time1,
                        @RequestParam(value = "ofday[1]",required = false) String time2,
                        @RequestParam("no") Integer no, @RequestParam(value = "size", required = false) Integer size
                        ){
        Integer pagesize = 5;
        if (size != null) {
            pagesize = size;
        }
        return MyResult.okAndpage(es.selectmou(ename,ephone,sex,time1,time2,no, pagesize));
    }
}
