package com.study.model.mdao;

import com.study.pojo.Dizhi;
import com.study.pojo.Huiyirenyuan;
import com.study.pojo.Xiangqing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: TianMing
 * @Description:
 * @Date: create in 2020/12/21 17:48
 */
@Mapper
@Repository
public interface ITmHuiYiMapper {

    //查询会议地址
    List<Dizhi> cxdz();

    //查询会议详情信息
    List<Xiangqing> selecxq();

    //查询参与会议的人
   List<Huiyirenyuan> selecyg(Integer hydzid);

   //添加新会议室
     Integer tjdz(@Param("i") Dizhi i);

}
