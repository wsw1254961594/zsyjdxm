package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IPropertyMapper;
import com.study.model.mdao.PropertyAssetMapper;
import com.study.pojo.Asset;
import com.study.pojo.Property;
import com.study.pojo.Prreturn;
import com.study.vo.PropertyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/22 8:59
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PropertyServices {
    @Autowired
    IPropertyMapper propertyMapper;

    @Autowired
    PropertyAssetMapper propertyAssetMapper;

    /*查询我的资产全部信息*/
    public List<Property> selectPropertyAll(Integer enpno){
        return propertyMapper.selectPropertyAll(enpno);
    }
    /*查询我的资产表分页*/
    public PageInfo<Property> selectByProperty(Integer pageNO, Integer pageSize ,Integer empno){
        //1配置分页信息
        PageHelper.startPage(pageNO,pageSize);
        //2执行分页
        List<Property> list=propertyMapper.selectPropertyAll(empno);
        //将分页数据封装到PageInfo中
        PageInfo<Property> info=new PageInfo<>(list);
        return info;
    }
    /*新增我的资产表*/
    public void propxz(PropertyVo propertyVo){
        /*新增我的资产表*/
        propertyMapper.insertProperty(propertyVo);

        List<Asset> assetList = propertyVo.getAsser();
        for (Asset asset : assetList) {
            propertyAssetMapper.addProAss(propertyVo.getCpid(),asset.getAtid());
        }


    }

    /*高级查询我的资产根据 名称 领取日期 价格来查询*/
    public PageInfo<Property> selectsProperty(Integer pageNo, Integer pageSize, String pname, String pget, String pvalue) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper方法
        List<Property> list = propertyMapper.selectsProperty(pname, pget, pvalue);
        //把查询结果封装到分页对象
        PageInfo<Property> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}
