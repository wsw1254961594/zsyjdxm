package com.study.controller;

import com.study.pojo.Tasklist;
import com.study.services.TasklistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /*查询所有任务*/
    @RequestMapping("All")
    public List<Tasklist> selectAll(){
        return se.selectAll();
    }
}
