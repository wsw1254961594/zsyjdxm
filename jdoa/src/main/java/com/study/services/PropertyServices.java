package com.study.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mdao.IBackLogMapper;
import com.study.model.mdao.IEmpMapper;
import com.study.model.mdao.IPropertyMapper;
import com.study.model.mdao.PropertyAssetMapper;
import com.study.pojo.Asset;
import com.study.pojo.Backlog;
import com.study.pojo.Emp;
import com.study.pojo.Property;

import com.study.utils.DateUtils;
import com.study.vo.PropertyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/22 8:59
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PropertyServices {
    @Autowired
    IPropertyMapper propertyMapper;
    @Autowired
    private IEmpMapper empMapper;
    @Autowired
    private IBackLogMapper backLogMapper;
    @Autowired
    PropertyAssetMapper propertyAssetMapper;

    /*查询我的资产全部信息*/
    public List<Property> selectPropertyAll(Integer enpno){
        return propertyMapper.selectPropertyAll(enpno);
    }
    /*查询我的资产表分页*/
    public PageInfo<Property> selectByProperty(Integer pageNO, Integer pageSize ,Integer empno){
        //1配置分页信息
        PageHelper.startPage(pageNO,pageSize);
        //2执行分页
        List<Property> list=propertyMapper.selectPropertyAll(empno);
        //将分页数据封装到PageInfo中
        PageInfo<Property> info=new PageInfo<>(list);
        return info;
    }
    /*新增我的资产表*/
    public Integer insertProperty(PropertyVo propertyVo){
        try {
            int addpro = propertyMapper.insertProperty(propertyVo);
            if (addpro != 1) {
                System.out.println("新增有可能报错==========");
            }

            /*查询主键id*/
            int cpid=propertyMapper.selectCpid();
            System.err.println("cpid:"+cpid);
            List<Asset> assetList = propertyVo.getAsser();

            System.err.println("properId:"+propertyVo.getCpid());
            for (Asset asset : assetList) {

                propertyAssetMapper.addProAss(cpid,asset.getAtid());
            }
            /*新增待办表*/
            Emp emp = empMapper.leavesGetEmp(propertyVo.getMyemp().getEmpno());
            Backlog backlog = new Backlog();
            backlog.setBtetle("资产借用");
            backlog.setBianhao(propertyVo.getCpid());
            backlog.setBcondition(0);
            backlog.setBaccept(DateUtils.getDate());
            backlog.setEmpid(emp.getMgr());
            int addBackLog = backLogMapper.addBackLog(backlog);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }
/*    *//*新增我的资产表*//*
    public void propxz(PropertyVo propertyVo){
        *//*新增我的资产表*//*
        propertyMapper.insertProperty(propertyVo);

        System.out.println(propertyVo.toString());

        List<Asset> assetList = propertyVo.getAsser();
        for (int i = 0; i < assetList.size(); i++) {
            System.out.println(assetList.size());
            System.out.println(assetList.get(i).toString());
        }
        for (Asset asset : assetList) {
            propertyAssetMapper.addProAss(propertyVo.getCpid(),asset.getAtid());
        }


    }*/

    /*高级查询我的资产根据 名称 领取日期 价格来查询*/
    public PageInfo<Property> selectsProperty(Integer pageNo, Integer pageSize, String pname, String pget, String pvalue) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper方法
        List<Property> list = propertyMapper.selectsProperty(pname, pget, pvalue);
        //把查询结果封装到分页对象
        PageInfo<Property> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}
