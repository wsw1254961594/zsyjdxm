package com.study.model.mdao;

import com.study.pojo.Contract;
import com.study.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ZhongShangYu
 * @Description: 付款管理
 * @Date: create in 2020/12/23 11:01
 */
@Repository
@Mapper
public interface IPaymentMapper {
    //实际付款金额
    Integer selectcalNum();

    //查询所有付款记录
    List<Payment> selectAll();
}