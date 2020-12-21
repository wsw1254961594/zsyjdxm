package com.study.controller;

import com.study.config.MyResult;
import com.study.services.BorrowServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public MyResult selectBorrwAll(){
        return MyResult.returnObjs(borrowServices.selectBorrwAll());
    }
}
