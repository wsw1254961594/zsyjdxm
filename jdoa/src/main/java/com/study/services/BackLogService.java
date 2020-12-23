package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.model.mdao.IBackLogMapper;
import com.study.model.mdao.IEmpMapper;
import com.study.pojo.Approval;
import com.study.pojo.Backlog;
import com.study.pojo.Emp;
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
        List<Backlog> backlogs = backLogMapper.listBackLog(backlog);
        for (int i = 0; i < backlogs.size(); i++) {
            Emp emp = empMapper.leavesGetEmp(backlogs.get(i).getEmpid());
            if (backlogs.get(i).getEmpid() == 0) {
                backlogs.get(i).setMgrResp("admin");
            } else {
                backlogs.get(i).setMgrResp(emp.getEname());
            }
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
}
