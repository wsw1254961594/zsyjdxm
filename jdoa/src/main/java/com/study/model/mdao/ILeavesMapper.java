package com.study.model.mdao;

import com.study.pojo.Leaves;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: pengjia
 * @date: 2020/12/21
 * @description:
 */
@Repository
public interface ILeavesMapper {
    int addLeaves(Leaves leaves);
    Leaves getLeaves(Integer lid);
    List<Leaves> listLeaves();
}
