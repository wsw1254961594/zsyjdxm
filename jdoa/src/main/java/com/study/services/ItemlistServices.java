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
    /*分页查询项目*/
    public PageInfo<Itemlist> SelectSs(Integer pageNo, Integer pageSize,String pname, String types,
                                       String status, String jobtype ){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        if(pname!="") {
            String pn = "%" + pname + "%";
            List<Itemlist> list = mapper.SelectSs(pn, types, status, jobtype);
            return new PageInfo<>(list);
        }
        List<Itemlist> list = mapper.SelectSs(pname, types, status, jobtype);
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

    /*分页查询项目阶段为项目验收的所有项目*/
    public PageInfo<Itemlist> SelectStageof(Integer pageNo, Integer pageSize){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        List<Itemlist> list = mapper.SelectStageof();
        return new PageInfo<>(list);
    }

    /*根据id修改项目状态*/
    public Integer UpdateStatus(String status,Integer iid){
        return mapper.UpdateStatus(status,iid);
    }

    /*根据id修改项目阶段*/
    public Integer UpdateStageof(Integer iid){
        return mapper.UpdateStageof(iid);
    }

    /*新增项目*/
    public Integer DoInsert(Itemlists it){
        return mapper.DoInsert(it);
    }

    /*新增项目成员*/
    public Integer empDoInsert(Integer empno,Integer iid){
        return mapper.empDoInsert(empno,iid);
    }

    /*根据id删除项目*/
    public Integer doDelete(Integer iid){
        return mapper.doDelete(iid);
    }
}
