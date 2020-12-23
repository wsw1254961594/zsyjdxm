package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.model.mdao.IEmpMapper;
import com.study.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServices {
    @Autowired
    IEmpMapper mapper;

    public PageInfo<Emp> selectPage(Integer no, Integer size) {
        System.out.println("分页查询方法");
        PageHelper.startPage(no, size);
        List<Emp> list = mapper.selectall();
        PageInfo<Emp> info = new PageInfo<>(list);
        return info;
    }

    public Emp selectByeid(Integer eid){
        Emp emp=mapper.selectByeid(7);
        return emp;
    }


    //新增员工
    public Integer doinsert(Emp emp){
        try {
            return mapper.insert(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public PageInfo<Emp> selectmou(String ename,String ephone,String sex,String time1,String time2,Integer no, Integer size) {
        System.out.println("模糊查询方法");
        PageHelper.startPage(no, size);
        List<Emp> list = mapper.selectmohu(ename,ephone,sex,time1,time2);
        PageInfo<Emp> info = new PageInfo<>(list);
        return info;
    }

    public PageInfo<Emp> selectstate(Integer no, Integer size) {
        System.out.println("分页查询方法");
        PageHelper.startPage(no, size);
        List<Emp> list = mapper.selectstate();
        PageInfo<Emp> info = new PageInfo<>(list);
        return info;
    }

    public MyResult getEmpDetail(Integer empno) {
        Emp empDetail = mapper.getEmpDetail(empno);
        return MyResult.returnObj(empDetail);
    }

}
