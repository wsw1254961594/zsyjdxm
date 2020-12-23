package com.study.services;

import com.study.model.mdao.IJobMapper;
import com.study.pojo.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServices {
    @Autowired
    IJobMapper mapper;

    public Job selectByjid(Integer jid){
        Job job=mapper.selectByjid(jid);
        return job;
    }
}
