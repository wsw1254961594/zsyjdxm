package com.study.services;

import com.study.model.mdao.IContractStatisticsMapper;
import com.study.vo.conPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ZhongShangYu
 * @Description: 合同报表
 * @Date: create in 2020/12/24 15:54
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class ContractStatisticsServices {
    @Autowired
    IContractStatisticsMapper mapper;

    //查询所有合同的付款
    public List<conPayment> selectConPay(){
        return mapper.selectConPay();
    }
}
