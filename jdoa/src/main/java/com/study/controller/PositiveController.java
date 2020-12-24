package com.study.controller;

import com.study.config.MyResult;
import com.study.model.mdao.IBackLogMapper;
import com.study.model.mdao.IEmpMapper;
import com.study.pojo.Approval;
import com.study.pojo.Backlog;
import com.study.pojo.Emp;
import com.study.pojo.Positive;
import com.study.services.ApprovalServices;
import com.study.services.BackLogService;
import com.study.services.EmpServices;
import com.study.services.PositiveServices;
import com.study.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/positives")
@CrossOrigin   //跨域访问
public class PositiveController {
    @Autowired
    PositiveServices ps;
    @Autowired
    EmpServices es;
    @Autowired
    ApprovalServices as;
    @Autowired
    BackLogService bs;
    @Autowired
    private IEmpMapper empMapper;
    @Autowired
    private IBackLogMapper backLogMapper;

    //新增一条转正申请
    @RequestMapping("/add")
    public MyResult add(
                        @RequestParam("empno") Integer empno
                        ){
        Emp emp=es.selectByeid(empno);
        //修改员工状态
        Integer integer=es.update(empno);
        System.out.println(empno+"empno");
        return MyResult.ok("转正成功");
    }
}
