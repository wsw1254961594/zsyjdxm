package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.model.mdao.IBackLogMapper;
import com.study.model.mdao.IEmpMapper;
import com.study.model.mdao.IOverTimeMapper;
import com.study.pojo.Backlog;
import com.study.pojo.Emp;
import com.study.pojo.Jiaban;
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
public class OverTimeService {
    @Autowired
    private IOverTimeMapper overTimeMapper;
    @Autowired
    private IEmpMapper empMapper;
    @Autowired
    private IBackLogMapper backLogMapper;

    public MyResult insertJiaBan(Jiaban jiaban) {
        int addOverTime = overTimeMapper.addOverTime(jiaban);
        if (addOverTime != 1) {
            return MyResult.ERROR("加班申请失败");
        }
        Emp emp = empMapper.leavesGetEmp(jiaban.getReqEmpno());
        Backlog backlog = new Backlog();
        backlog.setBtetle("加班");
        backlog.setBianhao(jiaban.getJnid());
        backlog.setBcondition(0);
        backlog.setBaccept(DateUtils.getDate());
        backlog.setEmpid(emp.getMgr());
        backlog.setMyemp(emp);
        int addBackLog = backLogMapper.addBackLog(backlog);
        if (addBackLog != 1) {
            return MyResult.ERROR("加班申请失败");
        }
        return MyResult.SUCCESS;
    }

    public MyResult getJiaBan(Integer jnid) {
        Jiaban jiaBan = overTimeMapper.getJiaBan(jnid);
        return MyResult.returnObj(jiaBan);
    }

    public MyResult listJiaBan(Jiaban jiaban,Integer pageNum) {
        List<Jiaban> jiabans = overTimeMapper.listJiaBan(jiaban);
        PageHelper.startPage(pageNum,10);
        PageInfo<Jiaban> list = new PageInfo<>(jiabans);
        return MyResult.okAndpage(list);
    }
}
