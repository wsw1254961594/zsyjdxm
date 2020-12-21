package com.study.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Marketinfo {
    private Integer mkid;
    private Integer mnum;
    private Contract mycontract;
    private Productxs myproductxs;

    @Id
    @Column(name = "mkid", nullable = false)
    public Integer getMkid() {
        return mkid;
    }

    public void setMkid(Integer mkid) {
        this.mkid = mkid;
    }

    @Basic
    @Column(name = "mnum", nullable = true)
    public Integer getMnum() {
        return mnum;
    }

    public void setMnum(Integer mnum) {
        this.mnum = mnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marketinfo that = (Marketinfo) o;
        return Objects.equals(mkid, that.mkid) &&
                Objects.equals(mnum, that.mnum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mkid, mnum);
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
    @JoinColumn(name = "pxid", referencedColumnName = "pxid")
    public Productxs getMyproductxs() {
        return myproductxs;
    }

    public void setMyproductxs(Productxs myproductxs) {
        this.myproductxs = myproductxs;
    }
}
