package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IEmpMapper;
import com.study.model.mdao.ITmHuiYiMapper;
import com.study.pojo.*;
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
  //查询所有员工
    public List<Emp> yg()
    {
        return hy.selectm();
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
                "2",hydzid
        );
        hy.shiyong(shiyong);

    }

    //会议添加成功执行修改地址状态
    public  Integer dizhis(Integer dzid){
        return hy.xiugaidz(dzid);
    }


}