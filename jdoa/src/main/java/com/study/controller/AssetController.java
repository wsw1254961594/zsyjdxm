package com.study.controller;

import com.study.config.MyResult;
import com.study.services.AssetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 19:51
 */
@RestController
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    AssetServices assetServices;

    @RequestMapping("/all")
    /*查询资产表信息*/
    public MyResult selectAssetAll(){
        return MyResult.returnObjs(assetServices.selectAssetAll());
    }
}
