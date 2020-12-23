package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IBorrowMapper;
import com.study.pojo.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 20:42
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BorrowServices {
    @Autowired
    IBorrowMapper borrowMapper;

    /*查询资产借用表*/
    public List<Borrow> selectBorrwAll(Integer empno){
        return borrowMapper.selectBorrowAll(empno);
    }

    /*分页查询资产借用表*/
    public PageInfo<Borrow> selectByBorrow(Integer pageNo,Integer pageSize,Integer empno){
        //1配置分页信息
        PageHelper.startPage(pageNo,pageSize);
        //2执行分页
        List<Borrow> list=borrowMapper.selectBorrowAll(empno);
        //将分页数据封装到PageInfo中
        PageInfo<Borrow> info=new PageInfo<>(list);
        return info;
    }

    /*新增资产借用表*/
    public Integer insertBorrow(Borrow borrow){
        try {
            borrowMapper.insertBorrow(borrow);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }
    /*修改资产借用表*/
    public Integer updateBorrow(Borrow borrow){
        try {
            borrowMapper.updateBorrow(borrow);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    /*高级查询根据 名称 归还日期 价格来进行查询*/
    public PageInfo<Borrow> selectsBorrow(Integer pageNo,Integer pageSize,String bname,String bget ,String bvalue){
        //配置分页信息
        PageHelper.startPage(pageNo,pageSize);
        //调用Mapper方法
        List<Borrow> list=borrowMapper.selectsBorrow(bname,bget,bvalue);
        //把查询结果封装到分页对象
        PageInfo<Borrow> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
