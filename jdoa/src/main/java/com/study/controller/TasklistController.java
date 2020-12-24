package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.pojo.Tasklist;
import com.study.services.TasklistServices;
import com.study.vo.ItemTask;
import com.study.vo.Tasklists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 9:06
 */
@RestController
@RequestMapping("Tasklist")
public class TasklistController {

    @Autowired
    TasklistServices se;

    /*分页查询所有任务*/
    @RequestMapping("page")
    public PageInfo<ItemTask> SelectPager(Integer no, @RequestParam(required = false) Integer size){
        Integer pageSize = 10;
        if(size!=null){
            pageSize = size;
        }
        return se.SelectByPager(no,pageSize);
    }

    /*根据任务名称分页查询任务*/
    @RequestMapping("Mname")
    public PageInfo<ItemTask> SelectMname(Integer no, @RequestParam(required = false) Integer size, String mname){
        Integer pageSize = 10;
        if(size!=null){
            pageSize = size;
        }
        return se.SelectMname(no,pageSize,mname);
    }

    /*根据阶段分页查询任务*/
    @RequestMapping("Stage")
    public PageInfo<ItemTask> SelectStage(Integer no, @RequestParam(required = false) Integer size, String stage){
        Integer pageSize = 10;
        if(size!=null){
            pageSize = size;
        }
        return se.SelectStage(no,pageSize,stage);
    }

    /*根据项目名称分页查询所属任务*/
    @RequestMapping("Pname")
    public PageInfo<ItemTask> SelectPname(Integer no, @RequestParam(required = false) Integer size, String pname){
        Integer pageSize = 10;
        if(size!=null){
            pageSize = size;
        }
        return se.SelectPname(no,pageSize,pname);
    }

    /*根据id删除项目*/
    @RequestMapping("doDelete")
    public Integer doDelete(Integer iid){
        return se.doDelete(iid);
    }

    /*新增任务*/
    @RequestMapping("doInsert")
    public Integer DoInsert(String iid,String mname,String stage,String ingtime,String endtime,String taskdescription){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Integer i= Integer.valueOf(iid);
            Date start = sf.parse(ingtime);
            Date end = sf.parse(endtime);
            Tasklists t = new Tasklists(null,i,mname,stage,start,end,null,null,null,taskdescription);
            return se.DoInsert(t);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
