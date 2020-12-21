package com.study.services;

import com.study.config.MyResult;
import com.study.model.mdao.IEmpMapper;
import com.study.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: pengjia
 * @date: 2020/12/21
 * @description:
 */
@Service
public class EmpService {
    @Autowired
    private IEmpMapper empMapper;

    public MyResult login(Emp emp) {
        String ename = emp.getEname();
        Emp empResp = empMapper.login(ename);
        return MyResult.returnObj(empResp);
    }
}
