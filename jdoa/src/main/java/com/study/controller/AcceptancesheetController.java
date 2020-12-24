package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.pojo.Acceptancesheet;
import com.study.pojo.Itemlist;
import com.study.services.AcceptancesheetServices;
import com.study.vo.Tasklists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    /*分页查询所有验收单*/
    @RequestMapping("page")
    public PageInfo<Acceptancesheet> SelectPager(Integer no, @RequestParam(required = false) Integer size){
        Integer pageSize = 10;
        if(size!=null){
            pageSize = size;
        }
        return se.SelectByPager(no,pageSize);
    }

    /*根据id删除验收单*/
    @RequestMapping("doDelete")
    public Integer doDelete(Integer id){
        return se.doDelete(id);
    }

    /*新增验收单*/
    @RequestMapping("doInsert")
    public Integer DoInsert(Integer id,String pname,String a){
        return se.DoInsert(pname,a,id);
    }
}
