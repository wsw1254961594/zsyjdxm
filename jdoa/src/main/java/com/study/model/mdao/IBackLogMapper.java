package com.study.model.mdao;

import com.study.pojo.*;
import com.study.pojo.Approval;
import com.study.pojo.Backlog;
import com.study.pojo.Contract;
import com.study.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: pengjia
 * @date: 2020/12/22
 * @description:
 */
@Repository
public interface IBackLogMapper {
    int addBackLog(@Param("b") Backlog backlog);
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

    int insert(Backlog backlog);

    /**
     * 根据类型和编号查询付款
     * @param pmid
     * @return
     */
    Payment getPmidByTitleAndId(Integer pmid);

    /**
     * 修改付款申请状态
     * @param pmid
     * @return
     */
    int editPaymentState(Integer pmid);

    /**
     * 根据类型和编号查询员工
     * @param pvid
     * @return
     */
    Emp getEmpByTitleAndId(Integer pvid);

    /**
     * 修改员工状态
     * @return
     */
    int editEmpState(Integer empno);

    /**
     * 查询我发起的所有流程
     * @param backlog
     * @return
     */
    List<Backlog> listByMineFlow(@Param("bl") Backlog backlog);

    /**
     * 查询合同解除申请
     * @param bianhao
     * @return
     */
    Contractchange getByContractChangeByBianhao(Integer bianhao);

    /**
     * 修改合同解除状态
     * @param chid
     * @return
     */
    int editContractChange( Integer chid );


  /*  *
     * 合同解除修改为3
     * @param cid
     * @return
     */
    int relieveContract(@Param("cid") Integer cid,@Param("cstate")Integer cstate);

    /**
     * 合同结项修改为2
     * @param cid
     * @return
     */
    int conclusionContract(Integer cid);

    Contractchange selectByContractChangeByBianhao(Integer bianhao);

    Property getPropertyByBianhao(Integer bianhao);

    int editPropertyStatus(Integer cpid);

}
