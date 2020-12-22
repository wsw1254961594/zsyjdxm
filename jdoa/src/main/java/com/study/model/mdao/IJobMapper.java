package com.study.model.mdao;

import com.study.pojo.Job;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IJobMapper {
    Job selectByjid(Integer jid);
}
