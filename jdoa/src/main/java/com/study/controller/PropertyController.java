package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.pojo.Property;
import com.study.pojo.Prreturn;
import com.study.services.PropertyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/22 9:02
 * @Description:
 */
@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    PropertyServices propertyServices;
    /*查询我的资产全部信息*/
    @RequestMapping("/all")
    public MyResult selectPropertyAll(Integer empno){
        return MyResult.returnObjs(propertyServices.selectPropertyAll(empno));
    }
    /*分页查询全部信息*/
    @RequestMapping("/page")
    public MyResult selectByProperty(@RequestParam("pageNo") Integer pageNo,
                                     @RequestParam("pageSize") Integer pageSize,
                                     @RequestParam("empno") Integer empon) {
        int pNo = (pageNo != null && pageNo > 0) ? pageNo : 1;
        int pSize = (pageSize != null && pageSize > 0) ? pageSize : 3;
        return MyResult.returnObj(propertyServices.selectByProperty(pNo, pSize,empon));
    }

    /*高级查询我的资产根据 名称 领取日期 价格来查询*/
    @RequestMapping("/pages")
    public MyResult selectsProperty(@RequestParam(value = "pname", required = false) String pname,
                                    @RequestParam(value = "pget", required = false) String pget,
                                    @RequestParam(value = "pvalue", required = false) String pvalue,
                                    @RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize) {
        PageInfo<Property> pageInfo = propertyServices.selectsProperty(pageNo, pageSize, pname, pget, pvalue);
        return MyResult.returnObj(pageInfo);
    }
}
