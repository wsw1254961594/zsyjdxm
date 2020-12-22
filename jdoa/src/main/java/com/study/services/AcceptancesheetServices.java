package com.study.services;

import com.study.model.mdao.IAcceptancesheetMapper;
import com.study.pojo.Acceptancesheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 8:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AcceptancesheetServices {

    @Autowired
    IAcceptancesheetMapper mapper;

    /*查询所有验收单*/
    public List<Acceptancesheet> selectAll(){
        return mapper.selectAll();
    }
}
