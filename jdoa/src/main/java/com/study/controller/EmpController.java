package com.study.controller;

import com.study.config.EmpVO;
import com.study.config.MyResult;
import com.study.pojo.Dept;
import com.study.pojo.Emp;
import com.study.pojo.Jobmsg;
import com.study.pojo.Personal;
import com.study.services.*;
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
    @Autowired
    PersonalServices ps;
    @Autowired
    DeptServices ds;
    //分页查询
    @RequestMapping("/pages")
    public MyResult selectByPage(@RequestParam("no") Integer no, @RequestParam(value = "size", required = false) Integer size) {
        System.out.println("1111111111");
        Integer pagesize = 5;
        if (size != null) {
            pagesize = size;
        }
        return MyResult.okAndpage(es.selectPage(no, pagesize));
    }

    //根据eid查找
    @RequestMapping("/byeid")
    public MyResult selectByeid(Integer eid){
        Emp emp=es.selectByeid(eid);
        return MyResult.returnObj(emp);
    }

    //高级查询
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

    //新增员工
    @RequestMapping("/add")
    public MyResult doInsert(@RequestParam("ename")String ename,
                             @RequestParam("ephone")String ephone,
                             @RequestParam("sex")String sex,
                             @RequestParam("deptno")Integer deptno,
                             @RequestParam("jmid")Integer jmid){
        System.out.println(ename);
        System.out.println(ephone);
        System.out.println(sex);
        System.out.println(deptno);
        System.out.println(jmid);
        Emp emp=new Emp();
        emp.setState(1);
        emp.setEname(ename);
        emp.setEphone(ephone);
        emp.setSex(sex);
        emp.setOfday(new Timestamp(System.currentTimeMillis()));
        Jobmsg jobmsg=js.selectByjmid(jmid);
        emp.setMyjobmsg(jobmsg);
        Dept dept=ds.selectBydeptno(deptno);
        emp.setMydept(dept);
        Integer i=es.doinsert(emp);
        System.out.println("新增之后的emp"+emp.toString());
        if (i>0){
            Personal personal=new Personal();
            personal.setPassword("123456");
            personal.setMyemp(emp);
            Integer in=ps.doInsert(personal);
            return MyResult.ok("操作成功");
        }else {
            return MyResult.ERROR("操作失败");
        }

    }

    @RequestMapping("/Bystate")
    public MyResult selectBystate(@RequestParam("no") Integer no, @RequestParam(value = "size", required = false) Integer size){
        Integer pagesize = 5;
        if (size != null) {
            pagesize = size;
        }
        return MyResult.okAndpage(es.selectstate(no, pagesize));
    }
}
