package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.pojo.Payment;
import com.study.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/23 11:04
 */
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    PaymentServices ps;

    //实际付款金额
    @RequestMapping("calnum")
    public Integer selectcalNum(){
        return ps.selectcalNum();
    }

    //查询所有付款记录
    @RequestMapping("all")
    public MyResult selectAll(Integer pageNo,Integer pageSize){
        PageInfo<Payment> info=ps.selectAll(pageNo, pageSize);
        MyResult mr=MyResult.returnObj(info);
        return mr;
    }

    //新增付款记录
    @RequestMapping("addpay")
    public void insertPay(@RequestBody Payment payment){
        ps.insertPay(payment);
    }
}
