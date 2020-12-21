package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.ITmHuiYiMapper;
import com.study.pojo.Xiangqing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: TianMing
 * @Description: 查询会议详情信息
 * @Date: create in 2020/12/21 21:50
 */
@Service
public class TmXiangQingServices {
    @Autowired
    ITmHuiYiMapper tt;
    //分页查询地址信息
    public PageInfo<Xiangqing> selecthy(Integer pageNo, Integer pageSize) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper的查询方法
        List<Xiangqing> list = tt.selecxq();
        //将结果集封装到分页对象中
        PageInfo<Xiangqing> info = new PageInfo<>(list);
        //返回
        return info;
    }
}
