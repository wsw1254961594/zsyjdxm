package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.pojo.Asset;
import com.study.services.AssetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Asset> selectAssetAll(){
        return assetServices.selectAssetAll();
    }
    /*查询资产表和资产类别表分页*/
    @RequestMapping("/page")
    public MyResult selectByAsset(@RequestParam("pageNo") Integer pageNo,
                                  @RequestParam("pageSize") Integer pageSize) {
        int pNo = (pageNo != null && pageNo > 0) ? pageNo : 1;
        int pSize = (pageSize != null && pageSize > 0) ? pageSize : 3;
        return MyResult.returnObj(assetServices.selectByAsset(pNo, pSize));

    }
    /*高级查询*/
    @RequestMapping("/pages")
    public MyResult selectsAsset(@RequestParam(value = "atname", required = false) String atname,
                                       @RequestParam(value = "atmodel", required = false) String atmodel,
                                       @RequestParam(value = "aunits", required = false) String price,
                                       @RequestParam("pageNo") Integer pageNo,
                                       @RequestParam("pageSize") Integer pageSize) {
        PageInfo<Asset> pageInfo = assetServices.selectsAsset(pageNo, pageSize, atname, atmodel, price);
        return MyResult.returnObj(pageInfo);
    }
}
