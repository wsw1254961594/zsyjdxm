package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.pojo.Acceptancesheet;
import com.study.pojo.Itemlist;
import com.study.services.AcceptancesheetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 8:50
 */
@RestController
@RequestMapping("Acceptancesheet")
public class AcceptancesheetController {

    @Autowired
    AcceptancesheetServices se;


    /*分页查询所有项目*/
    @RequestMapping("page")
    public PageInfo<Acceptancesheet> SelectPager(Integer no, @RequestParam(required = false) Integer size){
        Integer pageSize = 10;
        if(size!=null){
            pageSize = size;
        }
        return se.SelectByPager(no,pageSize);
    }
}
