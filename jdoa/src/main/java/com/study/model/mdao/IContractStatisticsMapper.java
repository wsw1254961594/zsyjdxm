package com.study.model.mdao;

import com.study.vo.conPayment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ZhongShangYu
 * @Description: 合同报表
 * @Date: create in 2020/12/24 15:46
 */
@Repository
@Mapper
public interface IContractStatisticsMapper {
    //统计所有合同已付款金额
    List<conPayment> selectConPay();
}
