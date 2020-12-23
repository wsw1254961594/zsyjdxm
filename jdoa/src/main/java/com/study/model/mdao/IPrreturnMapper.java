package com.study.model.mdao;

import com.study.pojo.Asset;
import com.study.pojo.Property;
import com.study.pojo.Prreturn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    List<Prreturn> selectPrreturnAll(Integer empno);

    /*高级查询资产归还表根据 名称 归还日期 价格查询*/
    List<Prreturn> selectsPrreturn(@Param("rname") String rname, @Param("rget") String rget, @Param("rvalue") String rvalue);

}
