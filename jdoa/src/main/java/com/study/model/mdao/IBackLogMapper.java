package com.study.model.mdao;

import com.study.pojo.Backlog;
import com.study.pojo.Contract;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: pengjia
 * @date: 2020/12/22
 * @description:
 */
@Repository
public interface IBackLogMapper {
    int addBackLog(Backlog backlog);
    int editBackLog(Backlog backlog);
    Backlog getBackLog(Integer blid);
    List<Backlog> listBackLog(Backlog backlog);

    /**
     * 根据类型和编号查询合同详情
     * @param bianhao
     * @return
     */
    Contract getByTitleAndId(Integer bianhao);

    /**
     * 修改合同申请状态
     * @return
     */
    int editContractState(Integer cid);
}
