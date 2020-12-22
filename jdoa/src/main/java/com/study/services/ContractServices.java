package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IContractMapper;
import com.study.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ZhongShangYu
 * @Description: 我的合同
 * @Date: create in 2020/12/21 20:31
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ContractServices {
    @Autowired
    IContractMapper mapper;

    //查询所有采购合同金额
    public Integer selectCgMoney(Integer empno){
        return mapper.selectCgMoney(empno);
    }

    //查询进行中采购合同金额
    public Integer selectCgMoneyNow(Integer empno){
        return mapper.selectCgMoneyNow(empno);
    }

    //查询已完成采购合同金额
    public Integer selectCgMoneyEnd(Integer empno){
        return mapper.selectCgMoneyEnd(empno);
    }

    //查询采购合同
    public PageInfo<Contract> selectCgAll(Integer pageNo,Integer pageSize,Integer empno){
        PageHelper.startPage(pageNo,pageSize);
        List<Contract> list=mapper.selectCgAll(empno);
        PageInfo<Contract> info=new PageInfo<>(list);
        return info;
    }

    //多条件查询
    public PageInfo<Contract> selectCgBylike(String ctitle,
                                           String cnumber,
                                           Integer cstate,
                                           Integer empno,
                                           Integer pageNo,
                                           Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Contract> list=mapper.selectCgBylike(ctitle, cnumber, cstate, empno);
        PageInfo<Contract> info=new PageInfo<>(list);
        return info;
    }

    //查询所有采购产品
    public List<Productcg> selectAllPr(){
        return mapper.selectAllPr();
    }

    //采购合同发起
    public void addcg(Contract contract){
        /*新增主表*/
        Contract con=new Contract(null,
                contract.getCtitle(),
                contract.getCbody(),
                contract.getCnumber(),
                contract.getCmoney(),1,contract.getCday(),0,
                contract.getMyemp());
        mapper.insertContract(con);

        /*查询新增主键*/
        Contract cid=mapper.selectCid();

        /*新增客户表*/
        Supplier sup=new Supplier(null,
                contract.getMysupplier().getSname(),
                contract.getMysupplier().getRank(),
                contract.getMysupplier().getOpening(),
                contract.getMysupplier().getSman(),
                contract.getMysupplier().getSphone(),
                cid);
            mapper.insertSupplier(sup);
        System.out.println(con.getPurchaseinfos());
      /*  新增详情表*/
        for (Purchaseinfo p : contract.getPurchaseinfos()) {
            System.out.println("值"+p.getPnum());
            Purchaseinfo pur=new Purchaseinfo(null,
                    p.getPnum(),
                    cid,
                    p.getMyproductcg());
            mapper.insertPurchaseinfo(pur);
        }
    }
}
