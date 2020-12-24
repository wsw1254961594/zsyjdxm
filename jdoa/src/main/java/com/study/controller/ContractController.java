package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.config.MyResult;
import com.study.pojo.Contract;
import com.study.pojo.Productcg;
import com.study.services.ContractServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ZhongShangYu
 * @Description:我的合同
 * @Date: create in 2020/12/21 20:36
 */
@RestController
@RequestMapping("contract")
public class ContractController {
    @Autowired
    ContractServices cs;

    @RequestMapping("cgmoney")
    //查询所有采购合同金额
    public Integer selectCgMoney(Integer empno){
        return cs.selectCgMoney(empno);
    }

    @RequestMapping("cgmoneynow")
    //查询进行中采购合同金额
    public Integer selectCgMoneyNow(Integer empno){
        return cs.selectCgMoneyNow(empno);
    }

    @RequestMapping("cgmoneyend")
    //查询已完成采购合同金额
    public Integer selectCgMoneyEnd(Integer empno){
        return cs.selectCgMoneyEnd(empno);
    }

    @RequestMapping("cgall")
    //查询我的所有采购合同
    public MyResult selectCgAll(Integer pageNo,Integer pageSize,Integer empno){
        PageInfo<Contract> info=cs.selectCgAll(pageNo, pageSize, empno);
        MyResult mr=MyResult.returnObj(info);
        return mr;
    }

    @RequestMapping("cgbylike")
    //查询我的所有合同
    public MyResult selectCgBylike(String ctitle,
                                   String cnumber,
                                   Integer cstate,
                                   Integer empno,
                                   Integer pageNo,
                                   Integer pageSize
                                   ){

        PageInfo<Contract> info=cs.selectCgBylike(ctitle, cnumber, cstate, empno, pageNo, pageSize);
        MyResult mr=MyResult.returnObj(info);
        return mr;
    }

    @RequestMapping("allpr")
    //所有采购产品
    public List<Productcg> selectAllPr(){
        return cs.selectAllPr();
    }

    @RequestMapping("addcg")
    //新增采购
    public void addCg(@RequestBody Contract contract){
       cs.addcg(contract);
    }

    @RequestMapping("logcontract")
    //查询我的合同申请
    public MyResult selectLogContract(Integer empno,Integer pageNo,Integer pageSize){
        PageInfo<Contract> info=cs.selectLogContract(empno, pageNo, pageSize);
        MyResult mr=MyResult.returnObj(info);
        return mr;
    }

    @RequestMapping("consucc")
    //合同结项
    public void conSucc(Integer cid){
        cs.conSucc(cid);
    }

    @RequestMapping("condel")
    //合同结项
    public void conDel(Integer cid){
        cs.conDel(cid);
    }
}
