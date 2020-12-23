package com.study.controller;

import com.study.config.MyResult;
import com.study.pojo.Jiaban;
import com.study.services.OverTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: pengjia
 * @date: 2020/12/22
 * @description:
 */
@RestController
@RequestMapping("/work")
public class OverTimeController {
    @Autowired
    private OverTimeService overTimeService;

    @PostMapping("/add")
    public MyResult insertJiaBan(@RequestBody Jiaban jiaban) {
        return overTimeService.insertJiaBan(jiaban);
    }

    @GetMapping
    public MyResult getJiaBan(Integer jnid) {
        return overTimeService.getJiaBan(jnid);
    }

    @GetMapping("/list")
    public MyResult listJiaban(Jiaban jiaban,Integer pageNum) {
        return overTimeService.listJiaBan(jiaban,pageNum);
    }
}
