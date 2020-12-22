package com.study.services;

import com.study.model.mdao.ITasklistMapper;
import com.study.pojo.Tasklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 9:05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TasklistServices {

    @Autowired
    ITasklistMapper mapper;

    /*查询所有任务*/
    public List<Tasklist> selectAll(){
        return mapper.selectAll();
    }
}
