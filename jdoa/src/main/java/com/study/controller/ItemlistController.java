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

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    /*分页查询所有项目*/
    @RequestMapping("page")
    public PageInfo<Itemlist> SelectPager(Integer no, @RequestParam(required = false) Integer size){
        Integer pageSize = 10;
        if(size!=null){
            pageSize = size;
        }
        return se.SelectByPager(no,pageSize);
    }

    /*根据项目名称分页查询项目*/
    @RequestMapping("Pname")
    public PageInfo<Itemlist> SelectPname(Integer no, @RequestParam(required = false) Integer size,String pname){
        Integer pageSize = 10;
        if(size!=null){
            pageSize = size;
        }
        return se.SelectPname(no,size,pname);
    }

    /*根据项目类型分页查询项目*/
    @RequestMapping("Types")
    public  PageInfo<Itemlist> SelectTypes(Integer no, @RequestParam(required = false) Integer size,String types){
        Integer pageSize = 10;
        if(size!=null){
            pageSize = size;
        }
        return se.SelectTypes(no, size, types);
    }

    /*根据项目类型分页查询项目*/
    @RequestMapping("Status")
    public  PageInfo<Itemlist> SelectStatus(Integer no, @RequestParam(required = false) Integer size,String status){
        Integer pageSize = 10;
        if(size!=null){
            pageSize = size;
        }
        return se.SelectStatus(no, size, status);
    }

    /*根据id修改项目状态*/
    @RequestMapping("Update")
    public Integer updateStatus(String status,Integer iid){
        return se.UpdateStatus(status,iid);
    }

    /*新增项目*/
    @RequestMapping("doInsert")
    public Integer doInsert(String pname,String types,String status,
                            String j,String stageof,String p1,String p2,Integer empid) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date pla = sf.parse(p1);
            Date plan = sf.parse(p2);
            Itemlists it = new Itemlists(null, pname, types, null, j, null,
                    null, pla, plan, null, null, empid);
            return se.DoInsert(it);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
