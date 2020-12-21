package com.study.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Borrow {
    private Integer bid;
    private String bserial;
    private String bname;
    private String bstate;
    private String bquantity;
    private String bunits;
    private Date bstorage;
    private Date bget;
    private String bvalue;
    private String bremark;
    private Asset myasset;
    private Emp myemp;

    @Id
    @Column(name = "bid", nullable = false)
    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @Basic
    @Column(name = "bserial", nullable = true, length = 200)
    public String getBserial() {
        return bserial;
    }

    public void setBserial(String bserial) {
        this.bserial = bserial;
    }

    @Basic
    @Column(name = "bname", nullable = true, length = 200)
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Basic
    @Column(name = "bstate", nullable = true, length = 200)
    public String getBstate() {
        return bstate;
    }

    public void setBstate(String bstate) {
        this.bstate = bstate;
    }

    @Basic
    @Column(name = "bquantity", nullable = true)
    public String getBquantity() {
        return bquantity;
    }

    public void setBquantity(String bquantity) {
        this.bquantity = bquantity;
    }

    @Basic
    @Column(name = "bunits", nullable = true, length = 200)
    public String getBunits() {
        return bunits;
    }

    public void setBunits(String bunits) {
        this.bunits = bunits;
    }

    @Basic
    @Column(name = "bstorage", nullable = true)
    public Date getBstorage() {
        return bstorage;
    }

    public void setBstorage(Date bstorage) {
        this.bstorage = bstorage;
    }

    @Basic
    @Column(name = "bget", nullable = true)
    public Date getBget() {
        return bget;
    }

    public void setBget(Date bget) {
        this.bget = bget;
    }

    @Basic
    @Column(name = "bvalue", nullable = true, length = 200)
    public String getBvalue() {
        return bvalue;
    }

    public void setBvalue(String bvalue) {
        this.bvalue = bvalue;
    }

    @Basic
    @Column(name = "bremark", nullable = true, length = 200)
    public String getBremark() {
        return bremark;
    }

    public void setBremark(String bremark) {
        this.bremark = bremark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrow borrow = (Borrow) o;
        return Objects.equals(bid, borrow.bid) &&
                Objects.equals(bserial, borrow.bserial) &&
                Objects.equals(bname, borrow.bname) &&
                Objects.equals(bstate, borrow.bstate) &&
                Objects.equals(bquantity, borrow.bquantity) &&
                Objects.equals(bunits, borrow.bunits) &&
                Objects.equals(bstorage, borrow.bstorage) &&
                Objects.equals(bget, borrow.bget) &&
                Objects.equals(bvalue, borrow.bvalue) &&
                Objects.equals(bremark, borrow.bremark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bid, bserial, bname, bstate, bquantity, bunits, bstorage, bget, bvalue, bremark);
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
