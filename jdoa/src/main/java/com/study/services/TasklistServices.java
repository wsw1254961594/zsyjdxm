package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.ITasklistMapper;
import com.study.pojo.Itemlist;
import com.study.pojo.Tasklist;
import com.study.vo.ItemTask;
import com.study.vo.Tasklists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 9:05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TasklistServices {

    @Autowired
    ITasklistMapper mapper;


    /*分页查询所有任务*/
    public PageInfo<ItemTask> SelectByPager(Integer pageNo, Integer pageSize){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        List<ItemTask> list = mapper.selectAll();
        return new PageInfo<>(list);
    }

    /*分页查询任务*/
    public PageInfo<ItemTask> SelectMn(Integer pageNo, Integer pageSize, String mname, String stage, String pname){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        String m="%"+mname+"%";
        String s="%"+stage+"%";
        String p="%"+pname+"%";
        List<ItemTask> list = mapper.selectMn(m,s,p);
        return new PageInfo<>(list);
    }

    /*根据任务名称分页查询任务*/
    public PageInfo<ItemTask> SelectMname(Integer pageNo, Integer pageSize, String mname){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        String m="%"+mname+"%";
        List<ItemTask> list = mapper.selectMname(m);
        return new PageInfo<>(list);
    }

    /*根据阶段分页查询任务*/
    public PageInfo<ItemTask> SelectStage(Integer pageNo, Integer pageSize, String stage){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        String s="%"+stage+"%";
        List<ItemTask> list = mapper.selectStage(s);
        return new PageInfo<>(list);
    }

    /*根据项目名称分页查询所属任务*/
    public PageInfo<ItemTask> SelectPname(Integer pageNo, Integer pageSize, String pname){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        String p="%"+pname+"%";
        List<ItemTask> list = mapper.selectPname(p);
        return new PageInfo<>(list);
    }


    /*新增任务*/
    public Integer DoInsert(Tasklists t){
        return mapper.DoInsert(t);
    }

    /*根据id删除项目*/
    public Integer doDelete(Integer iid){
        return mapper.doDelete(iid);
    }


}
