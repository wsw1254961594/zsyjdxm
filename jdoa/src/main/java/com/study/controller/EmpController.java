package com.study.controller;

import com.study.config.EmpVO;
import com.study.config.MyResult;
import com.study.pojo.Emp;
import com.study.pojo.Jobmsg;
import com.study.pojo.Personal;
import com.study.services.EmpServices;
import com.study.services.JobServices;
import com.study.services.JobmsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/emps")
@CrossOrigin   //跨域访问
public class EmpController {
    @Autowired
    EmpServices es;
    @Autowired
    JobmsgService js;
    @Autowired
    JobServices jobServices;

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

//    @RequestMapping("/add")
//    public MyResult doInsert(@RequestBody EmpVO vo){
//        Emp emp=new Emp();
//        emp.setState(1);
//        emp.setOfday(new Timestamp(System.currentTimeMillis()));
//        Jobmsg jobmsg=js.selectByjmid(vo.getMyjobmsg().getJmid());
//        emp.setMyjobmsg(jobmsg);
//        Personal personal=new Personal();
//        personal.setMyemp(emp);
//        Integer i=es.doinsert(emp);
//    }
}
