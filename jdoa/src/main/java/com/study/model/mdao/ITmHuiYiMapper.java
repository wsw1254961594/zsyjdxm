package com.study.model.mdao;

import com.study.pojo.Dizhi;
import com.study.pojo.Xiangqing;
import org.apache.ibatis.annotations.Mapper;
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

}
