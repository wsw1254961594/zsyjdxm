package com.study.model.mdao;

import com.study.pojo.Borrow;
import com.study.pojo.Property;
import com.study.vo.PropertyVo;
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

    /*新增我的资产表*//*
    int insertProperty(PropertyVo propertyVo);

    *//*查询主键id*/
    Integer selectCpid();
    /*资产归还*/
    int updateProperty(@Param("property") Property property);

    /*新增我的资产表*/
    int insertProperty(@Param("property") PropertyVo property);
    /*新增详情表*/
    void insertBorrow(@Param("b")Borrow borrow);
    /*void insertpropertyasset(@Param("p")PropertyAssetMapper propertyAssetMapper);*/
    /*高级查询我的资产根据 名称 领取日期 价格来查询*/
    List<Property> selectsProperty(@Param("pname") String pname,@Param("pget") String pget,@Param("pvalue")String pvalue);
    void addProAss(@Param("cpid") Integer cpid, @Param("atid") Integer atid);

    List<Property> selectAllId();

}
