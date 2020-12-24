package com.study.vo;

import com.study.pojo.Emp;
import com.study.pojo.Supplier;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 22:11
 */
public class contractlist {
    private Integer cid;
    private String ctitle;
    private String cbody;
    private String cnumber;
    private BigDecimal cmoney;
    private Integer ctype;
    private Date cday;
    private Integer cstate;
    private Integer money;
    private Supplier mysupplier;
    private Emp myemp;

    public Supplier getMysupplier() {
        return mysupplier;
    }

    public void setMysupplier(Supplier mysupplier) {
        this.mysupplier = mysupplier;
    }

    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public String getCbody() {
        return cbody;
    }

    public void setCbody(String cbody) {
        this.cbody = cbody;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public BigDecimal getCmoney() {
        return cmoney;
    }

    public void setCmoney(BigDecimal cmoney) {
        this.cmoney = cmoney;
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public Date getCday() {
        return cday;
    }

    public void setCday(Date cday) {
        this.cday = cday;
    }

    public Integer getCstate() {
        return cstate;
    }

    public void setCstate(Integer cstate) {
        this.cstate = cstate;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
