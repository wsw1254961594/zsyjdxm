package com.study.controller;

import com.study.config.MyResult;
import com.study.model.mdao.IBackLogMapper;
import com.study.model.mdao.IEmpMapper;
import com.study.pojo.Backlog;
import com.study.pojo.Emp;
import com.study.pojo.Posts;
import com.study.services.EmpServices;
import com.study.services.PostsServices;
import com.study.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postsc")
@CrossOrigin   //跨域访问
public class PostsController {
    @Autowired
    PostsServices ps;
    @Autowired
    EmpServices es;
    @Autowired
    private IEmpMapper empMapper;
    @Autowired
    private IBackLogMapper backLogMapper;

    @RequestMapping("/insert")
    public MyResult add(@RequestParam("pcause") String pcause,
                        @RequestParam("yuanpost") Integer yuanpost,
                        @RequestParam("xinpost") Integer xinpost,
                        @RequestParam("yuandept") Integer yuandept,
                        @RequestParam("xindept") Integer xindept,
                        @RequestParam("empno") Integer empno
                        ){
        Emp emp=es.selectByeid(empno);
        //修改员工状态
        Integer ee=es.updatestate(empno);
        System.out.println(pcause);
        System.out.println(yuandept);
        System.out.println(yuanpost);
        System.out.println(xinpost);
        System.out.println(xindept);
        System.out.println(empno);
        Posts pp=new Posts();
        System.out.println(emp+"emp");
        pp.setTitle(emp.getEname()+"转岗申请");
        pp.setPcause(pcause);
        pp.setYuanpost(yuanpost);
        pp.setXinpost(xinpost);
        pp.setXindept(xindept);
        pp.setYuandept(yuandept);
        pp.setMyemp(emp);
        Integer i=ps.insertpost(pp);
        if (i>0){
            /*新增待办表*/
            Backlog backlog = new Backlog();
            backlog.setBtetle("调岗申请");
            Integer bb=ps.selectmax();
            backlog.setBianhao(bb);

            backlog.setBcondition(0);
            backlog.setBaccept(DateUtils.getDate());
            backlog.setEmpid(emp.getMgr());
            int addBackLog = backLogMapper.addBackLog(backlog);
            return MyResult.ok("申请成功");
        }else {
            return MyResult.ERROR("申请失败");
        }
    }

}
