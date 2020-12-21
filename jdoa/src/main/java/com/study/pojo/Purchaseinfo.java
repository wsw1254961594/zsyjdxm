package com.study.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Purchaseinfo {
    private Integer prid;
    private Integer pnum;
    private Contract mycontract;
    private Productcg myproductcg;

    @Id
    @Column(name = "prid", nullable = false)
    public Integer getPrid() {
        return prid;
    }

    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    @Basic
    @Column(name = "pnum", nullable = true)
    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchaseinfo that = (Purchaseinfo) o;
        return Objects.equals(prid, that.prid) &&
                Objects.equals(pnum, that.pnum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prid, pnum);
    }

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    public Contract getMycontract() {
        return mycontract;
    }

    public void setMycontract(Contract mycontract) {
        this.mycontract = mycontract;
    }

    @ManyToOne
    @JoinColumn(name = "pcid", referencedColumnName = "pcid")
    public Productcg getMyproductcg() {
        return myproductcg;
    }

    public void setMyproductcg(Productcg myproductcg) {
        this.myproductcg = myproductcg;
    }
}
