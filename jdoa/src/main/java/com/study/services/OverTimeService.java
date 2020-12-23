package com.study.services;

import com.study.config.MyResult;
import com.study.model.mdao.IOverTimeMapper;
import com.study.pojo.Jiaban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: pengjia
 * @date: 2020/12/22
 * @description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OverTimeService {
    @Autowired
    private IOverTimeMapper overTimeMapper;

    public MyResult insertJiaBan(Jiaban jiaban) {
        return MyResult.returnObjs(overTimeMapper.listJiaBan(jiaban));
    }
}
