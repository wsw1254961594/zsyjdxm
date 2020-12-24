package com.study.controller;

import com.study.services.ContractStatisticsServices;
import com.study.vo.conPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/24 15:56
 */

@RestController
@RequestMapping("statis")
public class ContractStatisticsController {
    @Autowired
    ContractStatisticsServices cs;

    //查询所有合同付款
    @RequestMapping("conpay")
    public List<conPayment> selectConPay(){
        return cs.selectConPay();
    }

}
