package com.study.model.mdao;

import com.study.pojo.Jiaban;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: pengjia
 * @date: 2020/12/22
 * @description:
 */
@Repository
public interface IOverTimeMapper {
    int addOverTime(Jiaban jiaban);
    Jiaban getJiaBan(Integer jnid);
    List<Jiaban> listJiaBan(Jiaban jiaban);
}
