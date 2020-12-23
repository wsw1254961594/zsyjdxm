package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.pojo.*;
import com.study.services.TmHuiYiServices;
import com.study.services.TmXiangQingServices;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author TianMing
 * @Date 2020/12/21 19:20
 * @Version 1.0
 */
@RestController
@RequestMapping("huiyi")
public class THuiYiController{
    @Autowired
    TmHuiYiServices hys;
    @Autowired
    TmXiangQingServices xq;
    //查询会议地址
    @RequestMapping("/dizhi")
    public PageInfo<Dizhi> all(@RequestParam(value = "pageNum", required = false) Integer pageNo,
                               @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Integer no = (pageNo != null && pageNo >= 1) ? pageNo : 1;
        Integer size = (pageSize != null) ? pageSize : 5;
        return hys.selectall(no, size);
    }
    //查询会议详细信息
    @RequestMapping("/xiangqing")
    public PageInfo<Xiangqing> hyall(@RequestParam(value = "pageNum", required = false) Integer pageNo,
                                   @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Integer no = (pageNo != null && pageNo >= 1) ? pageNo : 1;
        Integer size = (pageSize != null) ? pageSize : 5;
        return xq.selecthy(no, size);
    }
    //根据传过来的id查询参与的员工，
    @RequestMapping("/yg")
    public List<Huiyirenyuan> selecallyg( Integer hydzid){
        return xq.selecygall(hydzid);
    }

    //添加新的会议地址
    @RequestMapping("/tj")
    public Integer tjdzss(@RequestBody Dizhi i){
        return hys.tidzs(i);
    }
    //添加会议
    @RequestMapping("/hy")
    public void huiyis(@RequestBody Xiangqing c){
        System.out.println("x"+c);
          hys.huiyi(c);
    }
    //添加成功后修改地址状态
    @RequestMapping("/xgdzid")
    public  Integer dizhiss(@RequestParam(required = false,value = "dzid") Integer dzid){
        System.out.println(dzid);
        return hys.dizhis(dzid);
    }

    //下拉框的地址
    @RequestMapping("/xla")
    public List<Dizhi> xialakuang(){
        return hys.xiala();
    }
  //下拉查询所有员工
    @RequestMapping("/yuangong")
    public  List<Emp> yyg(){
        return  hys.yg();
    }



}
