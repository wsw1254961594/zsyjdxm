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
public class Payment {
    private Integer pmid;
    private Date pmdate;
    private BigDecimal pmmoney;
    private String pmpayee;
    private Contract mycontract;
    private String pmname;
    private Integer pmstate;
    private Emp myemp;

    public Payment() {
    }

    public Payment(Integer pmid, Date pmdate, BigDecimal pmmoney, String pmpayee, Contract mycontract, String pmname, Integer pmstate, Emp myemp) {
        this.pmid = pmid;
        this.pmdate = pmdate;
        this.pmmoney = pmmoney;
        this.pmpayee = pmpayee;
        this.mycontract = mycontract;
        this.pmname = pmname;
        this.pmstate = pmstate;
        this.myemp = myemp;
    }

    @Id
    @Column(name = "pmid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getPmid() {
        return pmid;
    }

    public void setPmid(Integer pmid) {
        this.pmid = pmid;
    }

    @Basic
    @Column(name = "pmdate", nullable = true)
    public Date getPmdate() {
        return pmdate;
    }

    public void setPmdate(Date pmdate) {
        this.pmdate = pmdate;
    }

    @Basic
    @Column(name = "pmmoney", nullable = true, precision = 2)
    public BigDecimal getPmmoney() {
        return pmmoney;
    }

    public void setPmmoney(BigDecimal pmmoney) {
        this.pmmoney = pmmoney;
    }

    @Basic
    @Column(name = "pmpayee", nullable = true, length = 200)
    public String getPmpayee() {
        return pmpayee;
    }

    public void setPmpayee(String pmpayee) {
        this.pmpayee = pmpayee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(pmid, payment.pmid) &&
                Objects.equals(pmdate, payment.pmdate) &&
                Objects.equals(pmmoney, payment.pmmoney) &&
                Objects.equals(pmpayee, payment.pmpayee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pmid, pmdate, pmmoney, pmpayee);
    }

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    public Contract getMycontract() {
        return mycontract;
    }

    public void setMycontract(Contract mycontract) {
        this.mycontract = mycontract;
    }

    @Basic
    @Column(name = "pmname", nullable = true, length = 255)
    public String getPmname() {
        return pmname;
    }

    public void setPmname(String pmname) {
        this.pmname = pmname;
    }

    @Basic
    @Column(name = "pmstate", nullable = true)
    public Integer getPmstate() {
        return pmstate;
    }

    public void setPmstate(Integer pmstate) {
        this.pmstate = pmstate;
    }

    @OneToOne
    @JoinColumn(name = "empno", referencedColumnName = "empno")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }
}
