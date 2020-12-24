package com.study.model.mdao;

import com.study.pojo.Acceptancesheet;
import com.study.vo.Itemlists;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 8:41
 */
@Mapper
@Repository
public interface IAcceptancesheetMapper {

    List<Acceptancesheet> selectAll();

    Integer DoInsert(String pname,String approvalstatus,Integer iid);

    Integer doDelete(Integer piid);
}
