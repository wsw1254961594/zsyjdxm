package com.study.controller;

import com.study.config.MyResult;
import com.study.pojo.Leaves;
import com.study.services.LeavesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: pengjia
 * @date: 2020/12/22
 * @description:
 */
@RestController
@RequestMapping("/leaves")
public class LeavesController {
    @Autowired
    private LeavesService leavesService;

    @PostMapping("/add")
    public MyResult insertLeaves(@RequestBody Leaves leaves) {
        return leavesService.insertLeaves(leaves);
    }

    @GetMapping("/list")
    public MyResult listLeaves(Leaves leaves,Integer pageNum) {
        return leavesService.listLeaves(leaves,pageNum);
    }

    @GetMapping
    public MyResult getLeaves(Integer lid) {
        return leavesService.getLeaves(lid);
    }
}
