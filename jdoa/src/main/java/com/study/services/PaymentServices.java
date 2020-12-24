package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IBackLogMapper;
import com.study.model.mdao.IEmpMapper;
import com.study.model.mdao.IPaymentMapper;
import com.study.pojo.Backlog;
import com.study.pojo.Emp;
import com.study.pojo.Payment;
import com.study.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * @Author: ZhongShangYu
 * @Description: 付款管理
 * @Date: create in 2020/12/23 11:01
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PaymentServices {
    @Autowired
    IPaymentMapper mapper;
    @Autowired
    private IEmpMapper empMapper;
    @Autowired
    private IBackLogMapper backLogMapper;


    //实际付款金额
    public Integer selectcalNum(){
        return mapper.selectcalNum();
    }

    //所有付款记录
    public PageInfo<Payment> selectAll(Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Payment> list=mapper.selectAll();
        PageInfo<Payment> info=new PageInfo<>(list);
        return info;
    }

    //新增付款记录
    public void insertPay(Payment payment){
        Payment p=new Payment(null,
                new Date(System.currentTimeMillis()),
                payment.getPmmoney(),
                payment.getPmpayee(),
                payment.getMycontract(),
                payment.getPmname(),
                0,
                payment.getMyemp());
        mapper.insertPay(p);

        Integer pmid=mapper.selectNewPmid();

        /*新增待办表*/
        Emp emp = empMapper.leavesGetEmp(payment.getMyemp().getEmpno());
        Backlog backlog = new Backlog();
        backlog.setBtetle("合同付款申请");
        backlog.setBianhao(pmid);
        backlog.setBcondition(0);
        backlog.setBaccept(DateUtils.getDate());
        backlog.setEmpid(emp.getMgr());
        int addBackLog = backLogMapper.addBackLog(backlog);
    }


}
