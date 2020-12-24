package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IAcceptancesheetMapper;
import com.study.pojo.Acceptancesheet;
import com.study.pojo.Itemlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 8:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AcceptancesheetServices {

    @Autowired
    IAcceptancesheetMapper mapper;

    /*分页查询所有验收单*/
    public PageInfo<Acceptancesheet> SelectByPager(Integer pageNo, Integer pageSize){
        System.out.println("分页业务类："+pageNo+"---"+pageSize);
        PageHelper.startPage(pageNo,pageSize);
        List<Acceptancesheet> list = mapper.selectAll();
        return new PageInfo<>(list);
    }

    /*新增验收单*/
    public Integer DoInsert(String pname,String approvalstatus,Integer iid){
        return mapper.DoInsert(pname, approvalstatus, iid);
    }

    /*根据id删除验收单*/
    public Integer doDelete(Integer piid){
        return mapper.doDelete(piid);
    }
}
