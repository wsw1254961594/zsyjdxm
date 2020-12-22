package com.study.model.mdao;

import com.study.pojo.Backlog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: pengjia
 * @date: 2020/12/22
 * @description:
 */
@Repository
public interface IBackLogMapper {
    int addBackLog(Backlog backlog);
    int editBackLog(Backlog backlog);
    Backlog getBackLog(Integer blid);
    List<Backlog> listBackLog(Backlog backlog);
}
