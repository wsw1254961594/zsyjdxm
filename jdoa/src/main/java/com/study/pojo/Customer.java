package com.study.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Customer {
    private Integer ctid;
    private String ctname;
    private String cttype;
    private String ctphone;
    private Contract mycontract;

    @Id
    @Column(name = "ctid", nullable = false)
    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    @Basic
    @Column(name = "ctname", nullable = true, length = 200)
    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    @Basic
    @Column(name = "cttype", nullable = true, length = 200)
    public String getCttype() {
        return cttype;
    }

    public void setCttype(String cttype) {
        this.cttype = cttype;
    }

    @Basic
    @Column(name = "ctphone", nullable = true, length = 200)
    public String getCtphone() {
        return ctphone;
    }

    public void setCtphone(String ctphone) {
        this.ctphone = ctphone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(ctid, customer.ctid) &&
                Objects.equals(ctname, customer.ctname) &&
                Objects.equals(cttype, customer.cttype) &&
                Objects.equals(ctphone, customer.ctphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ctid, ctname, cttype, ctphone);
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
