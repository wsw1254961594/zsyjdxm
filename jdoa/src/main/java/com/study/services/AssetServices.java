package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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



    /*查询资产表和资产别表分页*/
    public PageInfo<Asset> selectByAsset(Integer pageNO, Integer pageSize){
        //1配置分页信息
        PageHelper.startPage(pageNO,pageSize);
        //2执行分页
        List<Asset> list=assetMapper.selectAssetAll();
        //将分页数据封装到PageInfo中
        PageInfo<Asset> info=new PageInfo<>(list);
        return info;
    }
    /*高级查询*/
    public PageInfo<Asset> selectsAsset(Integer pageNo, Integer pageSize, String atname, String atmodel, String aunits) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper方法
        List<Asset> list = assetMapper.selectsAsset(atname, atmodel, aunits);
        //把查询结果封装到分页对象
        PageInfo<Asset> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
