package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IBackLogMapper;
import com.study.model.mdao.IEmpMapper;
import com.study.model.mdao.ITmHuiYiMapper;
import com.study.pojo.*;
import com.study.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
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
    @Autowired
     IEmpMapper empMapper;
    @Autowired
     IBackLogMapper backLogMapper;
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
    //会议室
    public List<Dizhi> xiala(){
        return hy.cxdz();
    }
  //查询所有员工
    public List<Emp> yg(){

        return hy.selectm();
    }
    //查询空闲的员工
    public List<Emp> kx(String kai,String jie){
        List<Emp> all= hy.selectm();
        List<Emp> k = hy.selechyry(kai,jie);


        List<String> namelist = new ArrayList<String>();
         for (int i = 0; i<k.size();i++){
             for (int j= 0 ;j<all.size();j++){
                 if (all.get(j).getEname().equals(k.get(i).getEname())){
                     all.remove(j);
                 }

             }


         }

        return  all;
    }




    //添加会议
    public void huiyi(Xiangqing c){
        //添加会议
         Xiangqing x = new Xiangqing(null,
                 c.getHyrw(),
                 c.getKaishitimedate(),
                 c.getJieshutime(),
                 c.getNeirong(),
                 c.getHyleixi(),
                 c.getMydizhi(),
                 c.getEse()
                 );
         hy.huiyitian(x);
    //查询转过来的id
         Xiangqing hydzid=hy.cxid();
        System.out.println("dd"+hydzid);
        //循环添加参与员工表
        for (Huiyirenyuan y : c.getRrr()) {
            Huiyirenyuan p =new Huiyirenyuan(null,y.getEmpsss(),hydzid
                    );
            hy.yuangongtian(p);
        }

        Shiyong shiyong = new Shiyong(
                null,
                "0",hydzid
        );
        hy.shiyong(shiyong);

        Emp emp = empMapper.leavesGetEmp(c.getEse().getEmpno());
        Backlog backlog = new Backlog();
        backlog.setBtetle("会议室申请");
        backlog.setBianhao(hydzid.getHydzid());
        backlog.setBcondition(0);
        backlog.setBaccept(DateUtils.getDate());
        backlog.setEmpid(emp.getMgr());
        int addBackLog = backLogMapper.addBackLog(backlog);

    }

    //会议添加成功执行修改地址状态
    public  Integer dizhis(Integer dzid){
        return hy.xiugaidz(dzid);
    }

    //下拉框会议室
    public List<Dizhi> x(){
        return hy.kx();
    }

    //结束会议
    public Integer jieshu(Integer ids){
        return hy.jieshu(ids);
    }


    //模糊分页查询会议信息
    public PageInfo<Xiangqing> selcemohu(Integer pageNo, Integer pageSize,String empname,String hyname) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper的查询方法
        List<Xiangqing> list = hy.mohu(empname,hyname);
        //将结果集封装到分页对象中
        PageInfo<Xiangqing> info = new PageInfo<>(list);
        //返回
        return info;
    }

    public Integer siyong(Integer syid){
        return hy.siyong(syid);
    }

}