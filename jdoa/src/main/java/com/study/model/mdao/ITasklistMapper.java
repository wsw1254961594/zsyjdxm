package com.study.model.mdao;

import com.study.vo.ItemTask;
import com.study.vo.Tasklists;
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

    List<ItemTask> selectAll();

    List<ItemTask> selectMn(String mname,String stage,String pname);

    List<ItemTask> selectMname(String mname);

    List<ItemTask> selectStage(String stage);

    List<ItemTask> selectPname(String pname);

    Integer DoInsert(Tasklists t);

    Integer doDelete(Integer iid);
}
