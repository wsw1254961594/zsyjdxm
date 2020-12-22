package com.study.controller;

import com.study.config.MyResult;
import com.study.services.PrreturnServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 21:40
 * @Description:
 */
@RestController
@RequestMapping("/prreturn")
public class PrreturnController {
    @Autowired
    PrreturnServices prreturnServices;

    @RequestMapping("/all")
    public MyResult selectPrreturnAll(){
        return MyResult.returnObjs(prreturnServices.selectPrreturnAll());
    }
}
