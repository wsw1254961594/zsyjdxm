package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.pojo.Dizhi;
import com.study.pojo.Xiangqing;
import com.study.services.TmHuiYiServices;
import com.study.services.TmXiangQingServices;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author TianMing
 * @Date 2020/12/21 19:20
 * @Version 1.0
 */
@RestController
@RequestMapping("huiyi")
public class THuiYiController{
    @Autowired
    TmHuiYiServices hys;
    @Autowired
    TmXiangQingServices xq;
    //查询会议地址
    @RequestMapping("/dizhi")
    public PageInfo<Dizhi> all(@RequestParam(value = "pageNum", required = false) Integer pageNo,
                               @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Integer no = (pageNo != null && pageNo >= 1) ? pageNo : 1;
        Integer size = (pageSize != null) ? pageSize : 5;
        return hys.selectall(no, size);
    }
    //查询会议详细信息
    @RequestMapping("/xiangqing")
    public PageInfo<Xiangqing> hyall(@RequestParam(value = "pageNum", required = false) Integer pageNo,
                                   @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Integer no = (pageNo != null && pageNo >= 1) ? pageNo : 1;
        Integer size = (pageSize != null) ? pageSize : 5;
        return xq.selecthy(no, size);
    }

}
