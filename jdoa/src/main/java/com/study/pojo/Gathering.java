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
public class Gathering {
    private Integer grid;
    private Date grdate;
    private BigDecimal grmoney;
    private String grpayee;
    private Contract mycontract;

    @Id
    @Column(name = "grid", nullable = false)
    public Integer getGrid() {
        return grid;
    }

    public void setGrid(Integer grid) {
        this.grid = grid;
    }

    @Basic
    @Column(name = "grdate", nullable = true)
    public Date getGrdate() {
        return grdate;
    }

    public void setGrdate(Date grdate) {
        this.grdate = grdate;
    }

    @Basic
    @Column(name = "grmoney", nullable = true, precision = 2)
    public BigDecimal getGrmoney() {
        return grmoney;
    }

    public void setGrmoney(BigDecimal grmoney) {
        this.grmoney = grmoney;
    }

    @Basic
    @Column(name = "grpayee", nullable = true, length = 200)
    public String getGrpayee() {
        return grpayee;
    }

    public void setGrpayee(String grpayee) {
        this.grpayee = grpayee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gathering gathering = (Gathering) o;
        return Objects.equals(grid, gathering.grid) &&
                Objects.equals(grdate, gathering.grdate) &&
                Objects.equals(grmoney, gathering.grmoney) &&
                Objects.equals(grpayee, gathering.grpayee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grid, grdate, grmoney, grpayee);
    }

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    public Contract getMycontract() {
        return mycontract;
    }

    public void setMycontract(Contract mycontract) {
        this.mycontract = mycontract;
    }
}
