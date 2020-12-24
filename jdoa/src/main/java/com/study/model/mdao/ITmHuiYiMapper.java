package com.study.model.mdao;

import com.study.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
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

     //查询所有员工
    List<Emp> selectm();

    //邀请会议人员查询不在这个时间段的人员
    List<Emp> selechyry(@Param("kai") String kai,@Param("jie")String jie);

   //添加会议室记录
   void huiyitian(@Param("x") Xiangqing c);
    //查询新添的会议记录id
   Xiangqing cxid();

   //修改状态
   Integer xiugaidz(Integer dzid);

    //添加会议记录同时添加参与人员的信息
    void yuangongtian(@Param("y") Huiyirenyuan y);

    //添加会议使用表记录
    void shiyong(@Param("v") Shiyong v);

    //添加审批
    void shenpi(@Param("s") Backlog s);

    //查询空闲会议室
    List<Dizhi> kx();

    //结束会议
    Integer jieshu(Integer ids);

    //根据名字 会议室查询
    List<Xiangqing> mohu(@Param("empname") String empname,@Param("hyname") String hyname);

    //添加成功修改使用表记录
    Integer siyong(Integer syid);
}
