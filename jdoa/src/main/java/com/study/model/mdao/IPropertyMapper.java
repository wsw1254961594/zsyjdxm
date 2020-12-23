package com.study.model.mdao;

import com.study.pojo.Property;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 19:14
 */
@Mapper
@Repository
public interface IPropertyMapper {

    /*查询我的资产*/
    List<Property> selectPropertyAll(Integer empno);

    /*高级查询我的资产根据 名称 领取日期 价格来查询*/
    List<Property> selectsProperty(@Param("pname") String pname,@Param("pget") String pget,@Param("pvalue")String pvalue);


}
