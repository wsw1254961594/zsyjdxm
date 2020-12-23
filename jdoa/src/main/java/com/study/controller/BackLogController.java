package com.study.controller;

import com.study.config.MyResult;
import com.study.pojo.Backlog;
import com.study.services.BackLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: pengjia
 * @date: 2020/12/23
 * @description:
 */
@RestController
@RequestMapping("/backlog")
public class BackLogController {
    @Autowired
    private BackLogService backLogService;

    @GetMapping("/list")
    public MyResult listBackLog(Backlog backlog,Integer pageNum) {
        return backLogService.listBackLog(backlog,pageNum);
    }

    @PostMapping("/agree")
    public MyResult agreeBacklog(@RequestBody Backlog backlog) {
        return backLogService.updateBackLog(backlog);
    }

    @PostMapping("/reject")
    public MyResult rejectBackLog(@RequestBody Backlog backlog) {
        return backLogService.updateBackLog(backlog);
    }
}
