package com.study.services;

import com.study.model.mdao.IApprovalMapper;
import com.study.pojo.Approval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalServices {
    @Autowired
    IApprovalMapper mapper;


}
