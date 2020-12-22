package com.study.model.mdao;

import com.study.pojo.Itemlist;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 8:53
 */
@Mapper
@Repository
public interface IItemlistMapper {

    List<Itemlist> selectAll();

    Itemlist selectPname(String pname);

    List<Itemlist> selectTypes(String types);

    Integer updateStatus(String status,Integer iid);
}
