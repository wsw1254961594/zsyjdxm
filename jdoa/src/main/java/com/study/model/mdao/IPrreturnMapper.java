package com.study.model.mdao;

import com.study.pojo.Prreturn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 21:31
 * @Description:
 */
@Mapper
@Repository
public interface IPrreturnMapper {
    /*查询资产归还*/
    List<Prreturn> selectPrreturnAll();
}
