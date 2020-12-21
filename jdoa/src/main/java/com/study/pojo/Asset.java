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
public class Asset {
    private Integer atid;
    private String atname;
    private String atmodel;
    private Integer atnum;
    private String atstate;
    private String aunits;
    private Date astorage;
    private BigDecimal price;
    private Assets myassets;
    private List<Borrow> borrows;
    private List<Property> propertys;
    private List<Prreturn> prreturns;

    @Id
    @Column(name = "atid", nullable = false)
    public Integer getAtid() {
        return atid;
    }

    public void setAtid(Integer atid) {
        this.atid = atid;
    }

    @Basic
    @Column(name = "atname", nullable = true, length = 200)
    public String getAtname() {
        return atname;
    }

    public void setAtname(String atname) {
        this.atname = atname;
    }

    @Basic
    @Column(name = "atmodel", nullable = true, length = 200)
    public String getAtmodel() {
        return atmodel;
    }

    public void setAtmodel(String atmodel) {
        this.atmodel = atmodel;
    }

    @Basic
    @Column(name = "atnum", nullable = true)
    public Integer getAtnum() {
        return atnum;
    }

    public void setAtnum(Integer atnum) {
        this.atnum = atnum;
    }

    @Basic
    @Column(name = "atstate", nullable = true, length = 200)
    public String getAtstate() {
        return atstate;
    }

    public void setAtstate(String atstate) {
        this.atstate = atstate;
    }

    @Basic
    @Column(name = "aunits", nullable = true, length = 200)
    public String getAunits() {
        return aunits;
    }

    public void setAunits(String aunits) {
        this.aunits = aunits;
    }

    @Basic
    @Column(name = "astorage", nullable = true)
    public Date getAstorage() {
        return astorage;
    }

    public void setAstorage(Date astorage) {
        this.astorage = astorage;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return Objects.equals(atid, asset.atid) &&
                Objects.equals(atname, asset.atname) &&
                Objects.equals(atmodel, asset.atmodel) &&
                Objects.equals(atnum, asset.atnum) &&
                Objects.equals(atstate, asset.atstate) &&
                Objects.equals(aunits, asset.aunits) &&
                Objects.equals(astorage, asset.astorage) &&
                Objects.equals(price, asset.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atid, atname, atmodel, atnum, atstate, aunits, astorage, price);
    }

    @ManyToOne
    @JoinColumn(name = "aid", referencedColumnName = "aid")
    public Assets getMyassets() {
        return myassets;
    }

    public void setMyassets(Assets myassets) {
        this.myassets = myassets;
    }

    @OneToMany(mappedBy = "myasset")
    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    @OneToMany(mappedBy = "myasset")
    public List<Property> getPropertys() {
        return propertys;
    }

    public void setPropertys(List<Property> propertys) {
        this.propertys = propertys;
    }

    @OneToMany(mappedBy = "myasset")
    public List<Prreturn> getPrreturns() {
        return prreturns;
    }

    public void setPrreturns(List<Prreturn> prreturns) {
        this.prreturns = prreturns;
    }
}
