package com.study.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/22 20:04
 */
@Entity
public class Supplier {
    private Integer sid;
    private String sname;
    private String rank;
    private String opening;
    private String sman;
    private String sphone;
    private Contract mycontract;

    public Supplier() {
    }

    public Supplier(Integer sid, String sname, String rank, String opening, String sman, String sphone, Contract mycontract) {
        this.sid = sid;
        this.sname = sname;
        this.rank = rank;
        this.opening = opening;
        this.sman = sman;
        this.sphone = sphone;
        this.mycontract = mycontract;
    }

    @Id
    @Column(name = "sid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "sname", nullable = true, length = 255)
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "rank", nullable = true, length = 255)
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "opening", nullable = true, length = 255)
    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    @Basic
    @Column(name = "sman", nullable = true, length = 255)
    public String getSman() {
        return sman;
    }

    public void setSman(String sman) {
        this.sman = sman;
    }

    @Basic
    @Column(name = "sphone", nullable = true, length = 255)
    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(sid, supplier.sid) &&
                Objects.equals(sname, supplier.sname) &&
                Objects.equals(rank, supplier.rank) &&
                Objects.equals(opening, supplier.opening) &&
                Objects.equals(sman, supplier.sman) &&
                Objects.equals(sphone, supplier.sphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, rank, opening, sman, sphone);
    }

    @OneToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    public Contract getMycontract() {
        return mycontract;
    }

    public void setMycontract(Contract mycontract) {
        this.mycontract = mycontract;
    }
}
