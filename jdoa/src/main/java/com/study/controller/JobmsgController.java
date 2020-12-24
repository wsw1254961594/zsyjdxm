package com.study.controller;

import com.study.config.MyResult;
import com.study.pojo.Dept;
import com.study.pojo.Jobmsg;
import com.study.services.JobmsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobmsg")
@CrossOrigin   //跨域访问
public class JobmsgController {
    @Autowired
    JobmsgService js;

    @RequestMapping("/bydeptno")
        public MyResult selectBydeptno(Integer deptno){
        List<Dept> list=js.selectbydeptno(deptno);
        return MyResult.returnObjs(list);
    }

    @RequestMapping("/byjmid")
    public MyResult selectByjmid(Integer jmid){
        Jobmsg jobmsg=js.selectByjmid(jmid);
        return MyResult.returnObj(jobmsg);
    }
}
