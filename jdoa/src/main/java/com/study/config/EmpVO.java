package com.study.config;

import com.study.pojo.Dept;
import com.study.pojo.Empconract;
import com.study.pojo.Jobmsg;
import com.study.pojo.Personal;

import java.math.BigDecimal;
import java.sql.Date;

public class EmpVO {
    private Integer empno;
    private String ename;
    private String ephone;
    private String sex;
    private Integer mgr;
    private BigDecimal sal;
    private Integer state;
    private Date ofday;

    private Jobmsg myjobmsg;
    private Dept mydept;
    private Empconract myempconract;
    private Personal mypersonal;


    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getOfday() {
        return ofday;
    }

    public void setOfday(Date ofday) {
        this.ofday = ofday;
    }

    public Jobmsg getMyjobmsg() {
        return myjobmsg;
    }

    public void setMyjobmsg(Jobmsg myjobmsg) {
        this.myjobmsg = myjobmsg;
    }

    public Dept getMydept() {
        return mydept;
    }

    public void setMydept(Dept mydept) {
        this.mydept = mydept;
    }

    public Empconract getMyempconract() {
        return myempconract;
    }

    public void setMyempconract(Empconract myempconract) {
        this.myempconract = myempconract;
    }

    public Personal getMypersonal() {
        return mypersonal;
    }

    public void setMypersonal(Personal mypersonal) {
        this.mypersonal = mypersonal;
    }

    public EmpVO(Integer empno, String ename, String ephone, String sex, Integer mgr, BigDecimal sal, Integer state, Date ofday, Jobmsg myjobmsg, Dept mydept, Empconract myempconract, Personal mypersonal) {
        this.empno = empno;
        this.ename = ename;
        this.ephone = ephone;
        this.sex = sex;
        this.mgr = mgr;
        this.sal = sal;
        this.state = state;
        this.ofday = ofday;
        this.myjobmsg = myjobmsg;
        this.mydept = mydept;
        this.myempconract = myempconract;
        this.mypersonal = mypersonal;
    }

    public EmpVO() {
    }

    @Override
    public String toString() {
        return "EmpVO{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", ephone='" + ephone + '\'' +
                ", sex='" + sex + '\'' +
                ", mgr=" + mgr +
                ", sal=" + sal +
                ", state=" + state +
                ", ofday=" + ofday +
                ", myjobmsg=" + myjobmsg +
                ", mydept=" + mydept +
                ", myempconract=" + myempconract +
                ", mypersonal=" + mypersonal +
                '}';
    }
}


