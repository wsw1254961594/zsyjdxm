package com.study.model.mdao;

import com.study.pojo.Positive;
import org.springframework.stereotype.Repository;

/**
 * @author: pengjia
 * @date: 2020/12/24
 * @description:
 */
@Repository
public interface IEniaMapper {
    /**
     * 待办返回、转正申请
     * @param pvid
     * @return
     */
    Positive getByPvIdToLeaves(Integer pvid);


}
