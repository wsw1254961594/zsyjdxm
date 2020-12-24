package com.study.model.mdao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/23 21:33
 * @Description:
 */
@Repository
public interface PropertyAssetMapper {
    int addProAss(@Param("cpid") Integer cpid, @Param("atid") Integer atid);

    /*查询主键id*/
    int selectCpid();
}
