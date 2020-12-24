package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.model.mdao.IBackLogMapper;
import com.study.model.mdao.IEmpMapper;
import com.study.model.mdao.ILeavesMapper;
import com.study.pojo.Backlog;
import com.study.pojo.Emp;
import com.study.pojo.Leaves;
import com.study.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: pengjia
 * @date: 2020/12/22
 * @description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LeavesService {
    @Autowired
    private ILeavesMapper leavesMapper;

    @Autowired
    private IBackLogMapper backLogMapper;

    @Autowired
    private IEmpMapper empMapper;

    public MyResult insertLeaves(Leaves leaves) {
        Emp emp = empMapper.leavesGetEmp(leaves.getReqEmpno());
        leaves.setMyemp(emp);
        int addLeaves = leavesMapper.addLeaves(leaves);
        if (addLeaves != 1) {
            return MyResult.ERROR("请假失败，稍后重试");
        }
        Backlog backlog = new Backlog();
        backlog.setBtetle("请假");
        backlog.setBianhao(leaves.getLid());
        backlog.setBcondition(0);
        backlog.setBaccept(DateUtils.getDate());
        backlog.setEmpid(emp.getMgr());
        backlog.setMyemp(emp);
        int addBackLog = backLogMapper.addBackLog(backlog);
        if (addBackLog != 1) {
            return MyResult.ERROR("请假失败，稍后重试");
        }
        return MyResult.SUCCESS;
    }

    public MyResult listLeaves(Leaves leaves,Integer pageNum) {
        List<Leaves> listLeaves = leavesMapper.listLeaves(leaves);
        PageHelper.startPage(pageNum,10);
        PageInfo<Leaves> list = new PageInfo<>(listLeaves);
        return MyResult.okAndpage(list);
    }

    public MyResult getLeaves(Integer lid) {
        Leaves leaves = leavesMapper.getLeaves(lid);
        return MyResult.returnObj(leaves);
    }
}
