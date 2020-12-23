package com.study.services;

import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IPaymentMapper;
import com.study.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //实际付款金额
    public Integer selectcalNum(){
        return mapper.selectcalNum();
    }

    //所有付款记录
    public PageInfo<Payment> selectAll(){

        return null;
    }
}
