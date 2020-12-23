package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IItemlistMapper;
import com.study.pojo.Itemlist;
import com.study.vo.Itemlists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 8:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ItemlistServices {

    @Autowired
    IItemlistMapper mapper;

    /*分页查询所有项目*/
    public PageInfo<Itemlist> SelectByPager(Integer pageNo, Integer pageSize){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        List<Itemlist> list = mapper.SelectAll();
        return new PageInfo<>(list);
    }

    /*根据项目名称分页查询项目*/
    public PageInfo<Itemlist> SelectPname(Integer pageNo, Integer pageSize,String pname){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        String p="%"+pname+"%";
        List<Itemlist> list = mapper.SelectPname(p);
        return new PageInfo<>(list);
    }

    /*根据项目类型分页查询项目*/
    public  PageInfo<Itemlist> SelectTypes(Integer pageNo, Integer pageSize,String types){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        String typ ="%"+types+"%";
        List<Itemlist> list = mapper.SelectTypes(typ);
        return new PageInfo<>(list);
    }

    /*根据项目状态分页查询项目*/
    public  PageInfo<Itemlist> SelectStatus(Integer pageNo, Integer pageSize,String status){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        String s ="%"+status+"%";
        List<Itemlist> list = mapper.SelectStatus(s);
        return new PageInfo<>(list);
    }

    /*根据id修改项目状态*/
    public Integer UpdateStatus(String status,Integer iid){
        return mapper.UpdateStatus(status,iid);
    }

    /*新增项目*/
    public Integer DoInsert(Itemlists it){
        return mapper.DoInsert(it);
    }
}
