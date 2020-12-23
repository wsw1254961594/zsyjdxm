package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.pojo.Borrow;
import com.study.services.BorrowServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 20:47
 * @Description:
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    BorrowServices borrowServices;

    @RequestMapping("/all")
    public MyResult selectBorrwAll() {
        return MyResult.returnObjs(borrowServices.selectBorrwAll());
    }

    /*分页查询资产借用表*/
    @RequestMapping("/page")
    public MyResult selectByBorrow(@RequestParam("pageNo") Integer pageNo,
                                   @RequestParam("pageSize") Integer pageSize) {
        int pNo = (pageNo != null && pageNo > 0) ? pageNo : 1;
        int pSize = (pageSize != null && pageNo > 0) ? pageSize : 3;
        return MyResult.returnObj(borrowServices.selectByBorrow(pNo, pSize));
    }
    /*高级查询根据 名称 归还日期 价格来进行查询*/
    @RequestMapping("/pages")
    public MyResult selectsBorrow(@RequestParam(value = "bname",required = false)String bname,
                                  @RequestParam(value = "bget",required = false)String bget,
                                  @RequestParam(value = "bvalue",required = false)String bvalue,
                                  @RequestParam("pageNo")Integer pageNo,
                                  @RequestParam("pageSize")Integer pageSize){
        PageInfo<Borrow> pageInfo=borrowServices.selectsBorrow(pageNo,pageSize,bname,bget,bvalue);
        return MyResult.returnObj(pageInfo);
    }
}
