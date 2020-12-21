package com.study.services;

import com.study.model.mdao.IAssetMapper;
import com.study.pojo.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 19:39
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AssetServices {
    @Autowired
    IAssetMapper assetMapper;
    /*查询资产表信息*/
    public List<Asset> selectAssetAll(){
        return assetMapper.selectAssetAll();
    }
}
