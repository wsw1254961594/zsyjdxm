package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.model.mdao.IBackLogMapper;
import com.study.model.mdao.IEmpMapper;
import com.study.pojo.*;
import com.study.model.mdao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: pengjia
 * @date: 2020/12/22
 * @description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BackLogService {
    @Autowired
    private IBackLogMapper backLogMapper;
    @Autowired
    private IEmpMapper empMapper;
    @Autowired
    private IContractMapper contractMapper;
    @Autowired
    private ILeavesMapper leavesMapper;
    @Autowired
    private IOverTimeMapper overTimeMapper;
    @Autowired
    private IPaymentMapper paymentMapper;

    public MyResult insertBackLog(Backlog backlog) {
        int addBackLog = backLogMapper.addBackLog(backlog);
        if (addBackLog != 1) {
            return MyResult.ERROR("待办新增错误");
        }
        return MyResult.SUCCESS;
    }

    public MyResult updateBackLog(Backlog backlog) {
        Integer blid = backlog.getBlid();
        Backlog backLogResult = backLogMapper.getBackLog(blid);
        if (backLogResult == null) {
            return MyResult.ERROR("没有该待办");
        }
        if (backLogResult.getBtetle().equals("采购合同申请")) {
            Contract byTitleAndId = backLogMapper.getByTitleAndId(backLogResult.getBianhao());
            int editContractState = backLogMapper.editContractState(byTitleAndId.getCid());
            if (editContractState != 1) {
                return MyResult.ERROR("合同状态修改失败");
            }
        }
        if (backLogResult.getBtetle().equals("合同付款申请")) {
            Payment pmidByTitleAndId = backLogMapper.getPmidByTitleAndId(backLogResult.getBianhao());
            int editPaymentState = backLogMapper.editPaymentState(pmidByTitleAndId.getPmid());
            if (editPaymentState != 1) {
                return MyResult.ERROR("合同付款状态修改失败");
            }
        }
        if (backLogResult.getBtetle().equals("转正申请")) {
            Emp empByTitleAndId = backLogMapper.getEmpByTitleAndId(backLogResult.getBianhao());
            int editEmpState = backLogMapper.editEmpState(empByTitleAndId.getEmpno());
            if (editEmpState != 1) {
                return MyResult.ERROR("转正申请失败");
            }
        }
        if (backLogResult.getBtetle().equals("合同解除申请")) {
            Contractchange byContractByBianhao = backLogMapper.getByContractChangeByBianhao(backLogResult.getBianhao());

            int editContractState = backLogMapper.relieveContract(byContractByBianhao.getMycontract().getCid(),3);
            if (editContractState != 1) {
                return MyResult.ERROR("合同解除失败");
            }
            int editContractChange = backLogMapper.editContractChange(byContractByBianhao.getChid());
            if (editContractChange != 1) {
                return MyResult.ERROR("合同解除失败");
            }
        }
        if (backLogResult.getBtetle().equals("合同结项申请")) {
            Contractchange byContractByBianhao = backLogMapper.selectByContractChangeByBianhao(backLogResult.getBianhao());

            int editContractState = backLogMapper.relieveContract(byContractByBianhao.getMycontract().getCid(),2);
            if (editContractState != 1) {
                return MyResult.ERROR("合同解除失败");
            }
            int editContractChange = backLogMapper.editContractChange(byContractByBianhao.getChid());
            if (editContractChange != 1) {
                return MyResult.ERROR("合同解除失败");
            }
        }
        if (backLogResult.getBtetle().equals("资产借用")) {
            Property propertyByBianhao = backLogMapper.getPropertyByBianhao(backLogResult.getBianhao());
            int editPropertyStatus = backLogMapper.editPropertyStatus(propertyByBianhao.getCpid());
            if (editPropertyStatus != 1) {
                return MyResult.ERROR("资产借用失败");
            }
        }


        int editBackLog = backLogMapper.editBackLog(backlog);
        if (editBackLog != 1) {
            return MyResult.ERROR("待办修改失败");
        }
        return MyResult.SUCCESS;
    }

    public MyResult getBackLog(Integer blid) {
        Backlog backLog = backLogMapper.getBackLog(blid);
        return MyResult.returnObj(backLog);
    }

    /**
     * 只能看到自己需处理的待办
     * @param backlog
     * @param pageNum
     * @return
     */
    public MyResult listBackLog(Backlog backlog,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Backlog> backlogs = backLogMapper.listBackLog(backlog);
        for (int i = 0; i < backlogs.size(); i++) {
            Emp emp = empMapper.leavesGetEmp(backlogs.get(i).getEmpid());
            if (backlogs.get(i).getEmpid() == 0) {
                backlogs.get(i).setMgrResp("admin");
            } else {
                backlogs.get(i).setMgrResp(emp.getEname());
            }
            /*//设置返回申请人
            if (backlogs.get(i).getBtetle().equals("采购合同申请")) {
                Emp byCidToLeaves = contractMapper.getByCidToLeaves(backlogs.get(i).getBianhao());
                backlogs.get(i).setApplicantResp(byCidToLeaves.getEname());
            }
            if (backlogs.get(i).getBtetle().equals("请假")) {
                Emp byLidToLeaves = leavesMapper.getByLidToLeaves(backlogs.get(i).getBianhao());
                backlogs.get(i).setApplicantResp(byLidToLeaves.getEname());
            }
            if (backlogs.get(i).getBtetle().equals("加班")) {
                Emp byJnIdToLeaves = overTimeMapper.getByJnIdToLeaves(backlogs.get(i).getBianhao());
                backlogs.get(i).setApplicantResp(byJnIdToLeaves.getEname());
            }
            if (backlogs.get(i).getBtetle().equals("转正申请")) {
                Emp empByTitleAndId = backLogMapper.getEmpByTitleAndId(backlogs.get(i).getBianhao());
                backlogs.get(i).setApplicantResp(empByTitleAndId.getEname());
            }
            if (backlogs.get(i).getBtetle().equals("合同结项申请")) {

            }
            if (backlogs.get(i).getBtetle().equals("合同解除申请")) {

            }
            if (backlogs.get(i).getBtetle().equals("合同付款申请")) {
                Emp byPmIdToLeaves = paymentMapper.getByPmIdToLeaves(backlogs.get(i).getBianhao());
                backlogs.get(i).setApplicantResp(byPmIdToLeaves.getEname());
            }*/
        }
        PageHelper.startPage(pageNum,10);
        PageInfo<Backlog> list = new PageInfo<>(backlogs);
        return MyResult.okAndpage(list);
    }

    //新增转正信息
    public Integer doinsert(Backlog backlog){
        try {
            return backLogMapper.insert(backlog);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public MyResult listAllByMineFlowPath(Backlog backlog,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Emp emp = new Emp();
        emp.setEmpno(backlog.getReqEmp());
        backlog.setMyemp(emp);
        List<Backlog> backlogs = backLogMapper.listByMineFlow(backlog);
        PageInfo<Backlog> list = new PageInfo<>(backlogs);
        return MyResult.okAndpage(list);
    }
}
