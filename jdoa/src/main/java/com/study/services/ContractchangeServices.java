package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IBackLogMapper;
import com.study.model.mdao.IContractchangeMapper;
import com.study.model.mdao.IEmpMapper;
import com.study.pojo.Backlog;
import com.study.pojo.Contractchange;
import com.study.pojo.Emp;
import com.study.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * @Author: ZhongShangYu
 * @Description: 合同变更
 * @Date: create in 2020/12/24 10:16
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class ContractchangeServices {
    @Autowired
    IContractchangeMapper mapper;
    @Autowired
    private IEmpMapper empMapper;
    @Autowired
    private IBackLogMapper backLogMapper;

    //新增变更记录
    public void addChange(Contractchange change){
        /*新增变更记录*/
        Contractchange cc=new Contractchange(null,
                change.getChtitle(),
                change.getChcause(),
                new Date(System.currentTimeMillis()),
                change.getChtype(),
                0,
                change.getMycontract(),
                change.getMyemp());
        mapper.addChange(cc);

        /*获取最新id*/
        Integer chid=mapper.selectChid();

        /*新增待办表*/
        Emp emp = empMapper.leavesGetEmp(change.getMyemp().getEmpno());
        Backlog backlog = new Backlog();
        backlog.setBtetle(change.getChtype()+"申请");
        backlog.setBianhao(chid);
        backlog.setBcondition(0);
        backlog.setBaccept(DateUtils.getDate());
        backlog.setEmpid(emp.getMgr());
        int addBackLog = backLogMapper.addBackLog(backlog);
    }

    //查询所有变更记录
    public PageInfo<Contractchange> selectAll(Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Contractchange> list=mapper.selectAll();
        PageInfo<Contractchange> info=new PageInfo<>(list);
        return info;
    }
}
