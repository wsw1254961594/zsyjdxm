package com.study.vo;

import com.study.pojo.Asset;
import com.study.pojo.Borrow;
import com.study.pojo.Emp;

import java.sql.Date;
import java.util.List;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/23 21:48
 * @Description:
 */
public class PropertyVo {
    private Integer cpid;
    private String pserial;
    private String pname;
    private String pstate;
    private Integer pquantity;
    private String punits;
    private Date pstorage;
    private Date pget;
    private String pvalue;
    private String premark;
    private List<Asset> asser;
    private List<Borrow> borrow;
    private Emp myemp;

    @Override
    public String toString() {
        return "PropertyVo{" +
                "cpid=" + cpid +
                ", pserial='" + pserial + '\'' +
                ", pname='" + pname + '\'' +
                ", pstate='" + pstate + '\'' +
                ", pquantity=" + pquantity +
                ", punits='" + punits + '\'' +
                ", pstorage=" + pstorage +
                ", pget=" + pget +
                ", pvalue='" + pvalue + '\'' +
                ", premark='" + premark + '\'' +
                '}';
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public String getPserial() {
        return pserial;
    }

    public void setPserial(String pserial) {
        this.pserial = pserial;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    public Integer getPquantity() {
        return pquantity;
    }

    public void setPquantity(Integer pquantity) {
        this.pquantity = pquantity;
    }

    public String getPunits() {
        return punits;
    }

    public void setPunits(String punits) {
        this.punits = punits;
    }

    public Date getPstorage() {
        return pstorage;
    }

    public void setPstorage(Date pstorage) {
        this.pstorage = pstorage;
    }

    public Date getPget() {
        return pget;
    }

    public void setPget(Date pget) {
        this.pget = pget;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }

    public String getPremark() {
        return premark;
    }

    public void setPremark(String premark) {
        this.premark = premark;
    }

    public List<Asset> getAsser() {
        return asser;
    }

    public void setAsser(List<Asset> asser) {
        this.asser = asser;
    }

    public List<Borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(List<Borrow> borrow) {
        this.borrow = borrow;
    }

    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }
}