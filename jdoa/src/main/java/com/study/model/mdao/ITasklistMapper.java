package com.study.model.mdao;

import com.study.pojo.Tasklist;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 9:04
 */
@Mapper
@Repository
public interface ITasklistMapper {

    List<Tasklist> selectAll();
}
