package com.study.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Prreturn {
    private Integer rtid;
    private String rserial;
    private String rname;
    private String rstate;
    private Integer rquantity;
    private String bunits;
    private Date rstorage;
    private Date rget;
    private BigDecimal rvalue;
    private String rremark;
    private Asset myasset;
    private Emp myemp;

    @Id
    @Column(name = "rtid", nullable = false)
    public Integer getRtid() {
        return rtid;
    }

    public void setRtid(Integer rtid) {
        this.rtid = rtid;
    }

    @Basic
    @Column(name = "rserial", nullable = true, length = 255)
    public String getRserial() {
        return rserial;
    }

    public void setRserial(String rserial) {
        this.rserial = rserial;
    }

    @Basic
    @Column(name = "rname", nullable = true, length = 255)
    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Basic
    @Column(name = "rstate", nullable = true, length = 255)
    public String getRstate() {
        return rstate;
    }

    public void setRstate(String rstate) {
        this.rstate = rstate;
    }

    @Basic
    @Column(name = "rquantity", nullable = true)
    public Integer getRquantity() {
        return rquantity;
    }

    public void setRquantity(Integer rquantity) {
        this.rquantity = rquantity;
    }

    @Basic
    @Column(name = "bunits", nullable = true, length = 255)
    public String getBunits() {
        return bunits;
    }

    public void setBunits(String bunits) {
        this.bunits = bunits;
    }

    @Basic
    @Column(name = "rstorage", nullable = true)
    public Date getRstorage() {
        return rstorage;
    }

    public void setRstorage(Date rstorage) {
        this.rstorage = rstorage;
    }

    @Basic
    @Column(name = "rget", nullable = true)
    public Date getRget() {
        return rget;
    }

    public void setRget(Date rget) {
        this.rget = rget;
    }

    @Basic
    @Column(name = "rvalue", nullable = true, precision = 2)
    public BigDecimal getRvalue() {
        return rvalue;
    }

    public void setRvalue(BigDecimal rvalue) {
        this.rvalue = rvalue;
    }

    @Basic
    @Column(name = "rremark", nullable = true, length = 255)
    public String getRremark() {
        return rremark;
    }

    public void setRremark(String rremark) {
        this.rremark = rremark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prreturn prreturn = (Prreturn) o;
        return Objects.equals(rtid, prreturn.rtid) &&
                Objects.equals(rserial, prreturn.rserial) &&
                Objects.equals(rname, prreturn.rname) &&
                Objects.equals(rstate, prreturn.rstate) &&
                Objects.equals(rquantity, prreturn.rquantity) &&
                Objects.equals(bunits, prreturn.bunits) &&
                Objects.equals(rstorage, prreturn.rstorage) &&
                Objects.equals(rget, prreturn.rget) &&
                Objects.equals(rvalue, prreturn.rvalue) &&
                Objects.equals(rremark, prreturn.rremark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rtid, rserial, rname, rstate, rquantity, bunits, rstorage, rget, rvalue, rremark);
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
