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

    /*查询所有项目*/
    public List<Itemlist> selectAll(){
        return mapper.selectAll();
    }

    /*分页查询所有项目*/
    public PageInfo<Itemlist> selectByPager(Integer pageNo, Integer pageSize){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        List<Itemlist> list = mapper.selectAll();
        return new PageInfo<>(list);
    }

    /*根据项目名称查询项目*/
    public Itemlist selectPname(String pname){
        return mapper.selectPname(pname);
    }

    /*根据项目类型查询项目*/
    public  List<Itemlist> selectTypes(String types){
        return mapper.selectTypes(types);
    }

    /*根据id修改项目状态*/
    public Integer updateStatus(String status,Integer iid){
        return mapper.updateStatus(status,iid);
    }

    /*新增项目*/
    public Integer doInsert(Itemlists it){
        return mapper.doInsert(it);
    }
}
