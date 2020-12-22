package com.study.model.mdao;

import com.study.pojo.Itemlist;
import com.study.vo.Itemlists;
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

    List<Itemlist> SelectAll();

    List<Itemlist> SelectPname(String pname);

    List<Itemlist> SelectTypes(String types);

    List<Itemlist> SelectStatus(String status);

    Integer UpdateStatus(String status,Integer iid);

    Integer DoInsert(Itemlists it);
}
