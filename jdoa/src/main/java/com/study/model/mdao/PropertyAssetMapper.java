package com.study.model.mdao;

import org.springframework.stereotype.Repository;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/23 21:33
 * @Description:
 */
@Repository
public interface PropertyAssetMapper {
    int addProAss(Integer cpid,Integer atid);
}
