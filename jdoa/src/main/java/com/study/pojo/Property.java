package com.study.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Property {
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
    private Asset myasset;
    private Emp myemp;

    @Id
    @Column(name = "cpid", nullable = false)
    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    @Basic
    @Column(name = "pserial", nullable = true, length = 200)
    public String getPserial() {
        return pserial;
    }

    public void setPserial(String pserial) {
        this.pserial = pserial;
    }

    @Basic
    @Column(name = "pname", nullable = true, length = 200)
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Basic
    @Column(name = "pstate", nullable = true, length = 200)
    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    @Basic
    @Column(name = "pquantity", nullable = true)
    public Integer getPquantity() {
        return pquantity;
    }

    public void setPquantity(Integer pquantity) {
        this.pquantity = pquantity;
    }

    @Basic
    @Column(name = "punits", nullable = true, length = 200)
    public String getPunits() {
        return punits;
    }

    public void setPunits(String punits) {
        this.punits = punits;
    }

    @Basic
    @Column(name = "pstorage", nullable = true)
    public Date getPstorage() {
        return pstorage;
    }

    public void setPstorage(Date pstorage) {
        this.pstorage = pstorage;
    }

    @Basic
    @Column(name = "pget", nullable = true)
    public Date getPget() {
        return pget;
    }

    public void setPget(Date pget) {
        this.pget = pget;
    }

    @Basic
    @Column(name = "pvalue", nullable = true, length = 200)
    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }

    @Basic
    @Column(name = "premark", nullable = true, length = 200)
    public String getPremark() {
        return premark;
    }

    public void setPremark(String premark) {
        this.premark = premark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(cpid, property.cpid) &&
                Objects.equals(pserial, property.pserial) &&
                Objects.equals(pname, property.pname) &&
                Objects.equals(pstate, property.pstate) &&
                Objects.equals(pquantity, property.pquantity) &&
                Objects.equals(punits, property.punits) &&
                Objects.equals(pstorage, property.pstorage) &&
                Objects.equals(pget, property.pget) &&
                Objects.equals(pvalue, property.pvalue) &&
                Objects.equals(premark, property.premark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpid, pserial, pname, pstate, pquantity, punits, pstorage, pget, pvalue, premark);
    }

    @ManyToOne
    @JoinColumn(name = "atid", referencedColumnName = "atid")
    public Asset getMyasset() {
        return myasset;
    }

    public void setMyasset(Asset myasset) {
        this.myasset = myasset;
    }

    @ManyToOne
    @JoinColumn(name = "empno", referencedColumnName = "empno")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }
}
