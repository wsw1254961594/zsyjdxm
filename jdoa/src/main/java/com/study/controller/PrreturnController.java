package com.study.controller;


import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.pojo.Asset;
import com.study.pojo.Prreturn;
import com.study.services.PrreturnServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    /*查询资产归还表*/
    @RequestMapping("/all")
    public MyResult selectPrreturnAll(){
        return MyResult.returnObjs(prreturnServices.selectPrreturnAll());
    }
    /*分页查询资产归还表*/
    @RequestMapping("/page")
    public MyResult selectByPrreturn(@RequestParam("pageNo") Integer pageNo,
                                     @RequestParam("pageSize") Integer pageSize) {
        int pNo = (pageNo != null && pageNo > 0) ? pageNo : 1;
        int pSize = (pageSize != null && pageSize > 0) ? pageSize : 3;
        return MyResult.returnObj(prreturnServices.selectByPrreturn(pNo, pSize));

    }

    /*高级查询资产归还表根据 名称 归还日期 价格查询*/
    @RequestMapping("/pages")
    public MyResult selectsPrreturn(@RequestParam(value = "rname", required = false) String rname,
                                    @RequestParam(value = "rget", required = false) String rget,
                                    @RequestParam(value = "rvalue", required = false) String rvalue,
                                    @RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize) {
        PageInfo<Prreturn> pageInfo = prreturnServices.selectsPrreturn(pageNo, pageSize, rname, rget, rvalue);
        return MyResult.returnObj(pageInfo);
    }
}
