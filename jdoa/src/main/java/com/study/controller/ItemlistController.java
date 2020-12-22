package com.study.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.pojo.Itemlist;
import com.study.vo.Itemlists;
import com.study.services.ItemlistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 8:55
 */
@RestController
@RequestMapping("Itemlist")
public class ItemlistController {

    @Autowired
    ItemlistServices se;

    /*查询所有项目*/
    @RequestMapping("All")
    public List<Itemlist> selectAll(){
        return se.selectAll();
    }

    /*分页查询所有项目*/
    @RequestMapping("page")
    public PageInfo<Itemlist> selectPager(Integer no, @RequestParam(required = false) Integer size){
        Integer pageSize = 10;
        if(size!=null){
            pageSize = size;
        }
        return se.selectByPager(no,pageSize);
    }

    /*根据项目名称查询项目*/
    @RequestMapping("Pname")
    public Itemlist selectPname(String pname){
        return se.selectPname(pname);
    }

    /*根据项目类型查询项目*/
    @RequestMapping("Types")
    public  List<Itemlist> selectTypes(String types){
        return se.selectTypes(types);
    }

    /*根据id修改项目状态*/
    @RequestMapping("Status")
    public Integer updateStatus(String status,Integer iid){
        return se.updateStatus(status,iid);
    }

    /*新增项目*/
    @RequestMapping("doInsert")
    public Integer doInsert(String pname,String types,String status,
                            String j,String p,String stageof,Integer empid){
        Date pla = new Date();
        Date plan = new Date();
        Date act = new Date();
        Date actu = new Date();
        Itemlists it = new Itemlists(null,pname,types,status,j,p,stageof,pla,plan,act,actu,empid);
        return se.doInsert(it);
    }
}
