package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.pojo.Contractchange;
import com.study.services.ContractchangeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZhongShangYu
 * @Description: 合同变更
 * @Date: create in 2020/12/24 10:19
 */

@RestController
@RequestMapping("changes")
public class ContractchangeController {
    @Autowired
    ContractchangeServices cs;

    @RequestMapping("addchange")
    //添加合同变更记录
    public void addChange(@RequestBody Contractchange changes){
        cs.addChange(changes);
    }

    @RequestMapping("all")
    //查询所有变更信息
    public MyResult selectAll(Integer pageNo,Integer pageSize){
        PageInfo<Contractchange> info=cs.selectAll(pageNo, pageSize);
        MyResult mr=MyResult.returnObj(info);
        return mr;
    }
}
