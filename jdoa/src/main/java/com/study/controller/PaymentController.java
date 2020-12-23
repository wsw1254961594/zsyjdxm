package com.study.controller;

import com.study.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("calnum")
    public Integer selectcalNum(){
        return ps.selectcalNum();
    }
}
