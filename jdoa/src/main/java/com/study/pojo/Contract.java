package com.study.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Contract {
    private Integer cid;
    private String ctitle;
    private String cbody;
    private String cnumber;
    private BigDecimal cmoney;
    private Integer ctype;
    private Date cday;
    private Integer cstate;
    private Emp myemp;
    private Customer mycustomer;
    private List<Gathering> gatherings;
    private List<Marketinfo> marketinfos;
    private List<Payment> payments;
    private List<Purchaseinfo> purchaseinfos;
    private Supplier mysupplier;

    public Contract() {
    }

    public Contract(Integer cid, String ctitle, String cbody, String cnumber, BigDecimal cmoney, Integer ctype, Date cday, Integer cstate, Emp myemp) {
        this.cid = cid;
        this.ctitle = ctitle;
        this.cbody = cbody;
        this.cnumber = cnumber;
        this.cmoney = cmoney;
        this.ctype = ctype;
        this.cday = cday;
        this.cstate = cstate;
        this.myemp = myemp;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "cid=" + cid +
                ", ctitle='" + ctitle + '\'' +
                ", cbody='" + cbody + '\'' +
                ", cnumber='" + cnumber + '\'' +
                ", cmoney=" + cmoney +
                ", ctype=" + ctype +
                ", cday=" + cday +
                ", cstate=" + cstate +
                ", myemp=" + myemp +
                ", mycustomer=" + mycustomer +
                ", gatherings=" + gatherings +
                ", marketinfos=" + marketinfos +
                ", payments=" + payments +
                ", purchaseinfos=" + purchaseinfos +
                ", mysupplier=" + mysupplier +
                '}';
    }

    @Id
    @Column(name = "cid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "ctitle", nullable = true, length = 200)
    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    @Basic
    @Column(name = "cbody", nullable = true, length = 200)
    public String getCbody() {
        return cbody;
    }

    public void setCbody(String cbody) {
        this.cbody = cbody;
    }

    @Basic
    @Column(name = "cnumber", nullable = true, length = 200)
    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    @Basic
    @Column(name = "cmoney", nullable = true, precision = 2)
    public BigDecimal getCmoney() {
        return cmoney;
    }

    public void setCmoney(BigDecimal cmoney) {
        this.cmoney = cmoney;
    }

    @Basic
    @Column(name = "ctype", nullable = true)
    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    @Basic
    @Column(name = "cday", nullable = true)
    public Date getCday() {
        return cday;
    }

    public void setCday(Date cday) {
        this.cday = cday;
    }

    @Basic
    @Column(name = "cstate", nullable = true)
    public Integer getCstate() {
        return cstate;
    }

    public void setCstate(Integer cstate) {
        this.cstate = cstate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(cid, contract.cid) &&
                Objects.equals(ctitle, contract.ctitle) &&
                Objects.equals(cbody, contract.cbody) &&
                Objects.equals(cnumber, contract.cnumber) &&
                Objects.equals(cmoney, contract.cmoney) &&
                Objects.equals(ctype, contract.ctype) &&
                Objects.equals(cday, contract.cday) &&
                Objects.equals(cstate, contract.cstate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, ctitle, cbody, cnumber, cmoney, ctype, cday, cstate);
    }

    @ManyToOne
    @JoinColumn(name = "empno", referencedColumnName = "empno")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }

    @OneToOne(mappedBy = "mycontract")
    public Customer getMycustomer() {
        return mycustomer;
    }

    public void setMycustomer(Customer mycustomer) {
        this.mycustomer = mycustomer;
    }

    @OneToMany(mappedBy = "mycontract")
    public List<Gathering> getGatherings() {
        return gatherings;
    }

    public void setGatherings(List<Gathering> gatherings) {
        this.gatherings = gatherings;
    }

    @OneToMany(mappedBy = "mycontract")
    public List<Marketinfo> getMarketinfos() {
        return marketinfos;
    }

    public void setMarketinfos(List<Marketinfo> marketinfos) {
        this.marketinfos = marketinfos;
    }

    @OneToMany(mappedBy = "mycontract")
    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @OneToMany(mappedBy = "mycontract")
    public List<Purchaseinfo> getPurchaseinfos() {
        return purchaseinfos;
    }

    public void setPurchaseinfos(List<Purchaseinfo> purchaseinfos) {
        this.purchaseinfos = purchaseinfos;
    }

    @OneToOne(mappedBy = "mycontract")
    public Supplier getMysupplier() {
        return mysupplier;
    }

    public void setMysupplier(Supplier mysupplier) {
        this.mysupplier = mysupplier;
    }
}
