package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IEmpMapper;
import com.study.model.mdao.ITmHuiYiMapper;
import com.study.pojo.Dizhi;
import com.study.pojo.Emp;
import com.study.pojo.Xiangqing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author TianMing
 * @Date 2020/12/21 19:10
 * @Version 1.0
 */
@Service
public class TmHuiYiServices {
    @Autowired
    ITmHuiYiMapper hy;
    @Autowired
    IEmpMapper  e;
    //分页查询地址信息
    public PageInfo<Dizhi> selectall(Integer pageNo, Integer pageSize) {
        //配置分页信息
        System.out.println("开始");
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper的查询方法
        List<Dizhi> list = hy.cxdz();
        //将结果集封装到分页对象中
        PageInfo<Dizhi> info = new PageInfo<>(list);
        //返回
        return info;
    }
    //添加新的会议地址
    public Integer tidzs(Dizhi i){
        return  hy.tjdz(i);
    }
    //下拉框会议室
    public List<Dizhi> xiala(){
        return hy.cxdz();
    }
   /* //查询所有员工
    public List<Emp> yg()
    {
        return e.selectm();
    }
*/
}