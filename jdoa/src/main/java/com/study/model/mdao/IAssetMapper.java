package com.study.model.mdao;

import com.study.pojo.Asset;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 19:22
 */
@Mapper
@Repository
public interface IAssetMapper {
    /*查询资产表信息*/
   List<Asset> selectAssetAll();
}
