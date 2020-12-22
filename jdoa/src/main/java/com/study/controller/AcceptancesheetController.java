package com.study.controller;

import com.study.pojo.Acceptancesheet;
import com.study.services.AcceptancesheetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    /*查询所有验收单**/
    @RequestMapping("All")
    public List<Acceptancesheet> selectAll(){
        return se.selectAll();
    }
}
