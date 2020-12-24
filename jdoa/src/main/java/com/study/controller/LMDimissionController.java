package com.study.controller;

import com.study.config.MyResult;
import com.study.model.mdao.IBackLogMapper;
import com.study.model.mdao.IEmpMapper;
import com.study.pojo.Backlog;
import com.study.pojo.Dimission;
import com.study.pojo.Emp;
import com.study.services.EmpServices;
import com.study.services.LMDimissionServices;
import com.study.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LiaoMiao
 * @Description:
 * @Date: create in 2020/12/24 14:45
 */
@RestController
@RequestMapping("/dimissions")
@CrossOrigin   //跨域访问
public class LMDimissionController {
    @Autowired
    LMDimissionServices ls;
    @Autowired
    EmpServices es;
    @Autowired
    private IEmpMapper empMapper;
    @Autowired
    private IBackLogMapper backLogMapper;

    @RequestMapping("/add")
    public MyResult add(@RequestParam("dcause") String dcause,
                        @RequestParam("empno") Integer empno
                        ){
        Emp emp=es.selectByeid(empno);
        //修改员工状态
        Integer integer=es.updatelizhi(empno);
        Dimission dimission=new Dimission();
        dimission.setDdate(DateUtils.getDate());
        dimission.setDcause(dcause);
        dimission.setMyemp(emp);
        Integer i=ls.insert(dimission);
        if (i>0){
            /*新增待办表*/
            Backlog backlog = new Backlog();
            backlog.setBtetle("离职申请");
            Integer bb=ls.selectmax();
            backlog.setBianhao(bb);

            backlog.setBcondition(0);
            backlog.setBaccept(DateUtils.getDate());
            backlog.setEmpid(emp.getMgr());
            backlog.setMyemp(emp);
            int addBackLog = backLogMapper.addBackLog(backlog);
            return MyResult.ok("申请成功");
        }else {
            return MyResult.ERROR("申请失败");
        }
    }
}
