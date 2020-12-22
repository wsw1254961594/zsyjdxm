package com.study.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Emp {
    private Integer empno;
    private String ename;
    private String ephone;
    private String sex;
    private Integer mgr;
    private BigDecimal sal;
    private Integer state;
    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Timestamp ofday;
    
    private List<Borrow> borrow;
    private List<Contract> contracts;
    private Dimission dimissions;
    private Jobmsg myjobmsg;
    private Dept mydept;
    private Empconract myempconract;
    private List<Itemlist> itemlists;
    private List<Jiaban> jiabans;
    private List<Leaves> leaves;
    private Personal mypersonal;
    private List<Positive> positives;
    private List<Posts> posts;
    private List<Property> propertys;
    private List<Prreturn> prreturns;
    private List<Xiangqing> xiangqings;
    private List<Xiangqing> xqs;
    private List<Huiyirenyuan> ry;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno", nullable = false)
    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    @Basic
    @Column(name = "ename", nullable = true, length = 50)
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "ephone", nullable = true, length = 20)
    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 10)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "mgr", nullable = true)
    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    @Basic
    @Column(name = "sal", nullable = true, precision = 2)
    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "ofday", nullable = true)
    public Timestamp getOfday() {
        return ofday;
    }

    public void setOfday(Timestamp ofday) {
        this.ofday = ofday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(empno, emp.empno) &&
                Objects.equals(ename, emp.ename) &&
                Objects.equals(ephone, emp.ephone) &&
                Objects.equals(sex, emp.sex) &&
                Objects.equals(mgr, emp.mgr) &&
                Objects.equals(sal, emp.sal) &&
                Objects.equals(state, emp.state) &&
                Objects.equals(ofday, emp.ofday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno, ename, ephone, sex, mgr, sal, state, ofday);
    }

    @OneToMany(mappedBy = "myemp")
    public List<Borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(List<Borrow> borrow) {
        this.borrow = borrow;
    }

    @OneToMany(mappedBy = "myemp")
    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @OneToOne(mappedBy = "myemp")
    public Dimission getDimissions() {
        return dimissions;
    }

    public void setDimissions(Dimission dimissions) {
        this.dimissions = dimissions;
    }

    @OneToOne
    @JoinColumn(name = "jmid", referencedColumnName = "jmid")
    public Jobmsg getMyjobmsg() {
        return myjobmsg;
    }

    public void setMyjobmsg(Jobmsg myjobmsg) {
        this.myjobmsg = myjobmsg;
    }

    @ManyToOne
    @JoinColumn(name = "deptno", referencedColumnName = "deptno")
    public Dept getMydept() {
        return mydept;
    }

    public void setMydept(Dept mydept) {
        this.mydept = mydept;
    }

    @OneToOne(mappedBy = "myemp")
    public Empconract getMyempconract() {
        return myempconract;
    }

    public void setMyempconract(Empconract myempconract) {
        this.myempconract = myempconract;
    }

    @ManyToMany(mappedBy = "emps")
    public List<Itemlist> getItemlists() {
        return itemlists;
    }

    public void setItemlists(List<Itemlist> itemlists) {
        this.itemlists = itemlists;
    }

    @OneToMany(mappedBy = "myemp")
    public List<Jiaban> getJiabans() {
        return jiabans;
    }

    public void setJiabans(List<Jiaban> jiabans) {
        this.jiabans = jiabans;
    }

    @OneToMany(mappedBy = "myemp")
    public List<Leaves> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Leaves> leaves) {
        this.leaves = leaves;
    }

    @OneToOne(mappedBy = "myemp")
    public Personal getMypersonal() {
        return mypersonal;
    }

    public void setMypersonal(Personal mypersonal) {
        this.mypersonal = mypersonal;
    }

    @OneToMany(mappedBy = "myemp")
    public List<Positive> getPositives() {
        return positives;
    }

    public void setPositives(List<Positive> positives) {
        this.positives = positives;
    }

    @OneToMany(mappedBy = "myemp")
    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    @OneToMany(mappedBy = "myemp")
    public List<Property> getPropertys() {
        return propertys;
    }

    public void setPropertys(List<Property> propertys) {
        this.propertys = propertys;
    }

    @OneToMany(mappedBy = "myemp")
    public List<Prreturn> getPrreturns() {
        return prreturns;
    }

    public void setPrreturns(List<Prreturn> prreturns) {
        this.prreturns = prreturns;
    }



    @OneToMany(mappedBy = "ese")
    public List<Xiangqing> getXqs() {
        return xqs;
    }

    public void setXqs(List<Xiangqing> xqs) {
        this.xqs = xqs;
    }

    @OneToMany(mappedBy = "empsss")
    public List<Huiyirenyuan> getRy() {
        return ry;
    }

    public void setRy(List<Huiyirenyuan> ry) {
        this.ry = ry;
    }
}
