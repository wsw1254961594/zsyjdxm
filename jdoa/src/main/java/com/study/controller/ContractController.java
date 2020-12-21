package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.pojo.Contract;
import com.study.services.ContractServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ZhongShangYu
 * @Description:我的合同
 * @Date: create in 2020/12/21 20:36
 */
@RestController
@RequestMapping("contract")
public class ContractController {
    @Autowired
    ContractServices cs;

    @RequestMapping("cgmoney")
    //查询所有采购合同金额
    public Integer selectCgMoney(Integer empno){
        return cs.selectCgMoney(empno);
    }

    @RequestMapping("cgmoneynow")
    //查询进行中采购合同金额
    public Integer selectCgMoneyNow(Integer empno){
        return cs.selectCgMoneyNow(empno);
    }

    @RequestMapping("cgmoneyend")
    //查询已完成采购合同金额
    public Integer selectCgMoneyEnd(Integer empno){
        return cs.selectCgMoneyEnd(empno);
    }

    @RequestMapping("all")
    //查询我的所有合同
    public MyResult selectCgAll(Integer pageNo,Integer pageSize,Integer empno){
        PageInfo<Contract> info=cs.selectCgAll(pageNo, pageSize, empno);
        MyResult mr=MyResult.returnObj(info);
        return mr;
    }
}
