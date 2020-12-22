package com.study.model.mdao;

import com.study.pojo.Contract;
import com.study.pojo.Payment;
import com.study.pojo.Productcg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ZhongShangYu
 * @Description: 我的合同
 * @Date: create in 2020/12/21 20:23
 */
@Mapper
@Repository
public interface IContractMapper {
    //查询采购合同总金额
    Integer selectCgMoney(Integer empno);

    //查询进行中采购合同总金额
    Integer selectCgMoneyNow(Integer empno);

    //查询已完成采购合同总金额
    Integer selectCgMoneyEnd(Integer empno);

    //查询我的所有合同信息
    List<Contract> selectCgAll(Integer empno);

    //查询合同已付款金额
    List<Payment> selectFkMoney();

    //多条件查询
    List<Contract> selectCgBylike(@Param("ctitle") String ctitle,
                               @Param("cnumber") String cnumber,
                               @Param("cstate") Integer cstate,
                               @Param("empno")Integer empno);

    //查询采购需要的产品
    List<Productcg> selectAllPr();
}
