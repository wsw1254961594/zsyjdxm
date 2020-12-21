package com.study.services;

import com.study.model.mdao.IPrreturnMapper;
import com.study.pojo.Prreturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 21:38
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PrreturnServices {
    @Autowired
    IPrreturnMapper prreturnMapper;

    /*查询资产归还信息*/
    public List<Prreturn> selectPrreturnAll(){
        return prreturnMapper.selectPrreturnAll();
    }
}
