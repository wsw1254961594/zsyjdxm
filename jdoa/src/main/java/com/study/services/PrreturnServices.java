package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IPrreturnMapper;
import com.study.pojo.Asset;
import com.study.pojo.Prreturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 21:38
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PrreturnServices {
    @Autowired
    IPrreturnMapper prreturnMapper;

    /*查询资产归还信息*/
    public List<Prreturn> selectPrreturnAll(){
        return prreturnMapper.selectPrreturnAll();
    }
    /*分页查询资产归还表*/
    public PageInfo<Prreturn> selectByPrreturn(Integer pageNO, Integer pageSize){
        //1配置分页信息
        PageHelper.startPage(pageNO,pageSize);
        //2执行分页
        List<Prreturn> list=prreturnMapper.selectPrreturnAll();
        //将分页数据封装到PageInfo中
        PageInfo<Prreturn> info=new PageInfo<>(list);
        return info;
    }
    /*高级查询我的资产根据 名称 领取日期 价格来查询*/
    public PageInfo<Prreturn> selectsPrreturn(Integer pageNo, Integer pageSize, String rname, String rget, String rvalue) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper方法
        List<Prreturn> list = prreturnMapper.selectsPrreturn(rname, rget, rvalue);
        //把查询结果封装到分页对象
        PageInfo<Prreturn> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
