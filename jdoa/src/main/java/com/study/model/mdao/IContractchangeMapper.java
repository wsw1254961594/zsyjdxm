package com.study.model.mdao;

import com.study.pojo.Contractchange;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ZhongShangYu
 * @Description: 合同变更
 * @Date: create in 2020/12/24 10:04
 */

@Repository
@Mapper
public interface IContractchangeMapper {
    //添加变更记录
    void addChange(@Param("c") Contractchange cc);

    //查找最新编号
    Integer selectChid();

    //查询所有变更信息
    List<Contractchange> selectAll();
}
