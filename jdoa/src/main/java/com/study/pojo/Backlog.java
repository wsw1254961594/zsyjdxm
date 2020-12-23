package com.study.pojo;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Backlog {
    private Integer blid;
    private String btetle;
    private Integer bianhao;
    private Integer bcondition;
    private Date baccept;

    private Integer empid;
    private Approval myapproval;
    private String mgrResp;

    public String getMgrResp() {
        return mgrResp;
    }

    public void setMgrResp(String mgrResp) {
        this.mgrResp = mgrResp;
    }

    @Id
    @Column(name = "blid", nullable = false)
    public Integer getBlid() {
        return blid;
    }

    public void setBlid(Integer blid) {
        this.blid = blid;
    }

    @Basic
    @Column(name = "btetle", nullable = true, length = 200)
    public String getBtetle() {
        return btetle;
    }

    public void setBtetle(String btetle) {
        this.btetle = btetle;
    }

    @Basic
    @Column(name = "bianhao", nullable = true)
    public Integer getBianhao() {
        return bianhao;
    }

    public void setBianhao(Integer bianhao) {
        this.bianhao = bianhao;
    }

    @Basic
    @Column(name = "bcondition", nullable = true)
    public Integer getBcondition() {
        return bcondition;
    }

    public void setBcondition(Integer bcondition) {
        this.bcondition = bcondition;
    }

    @Basic
    @Column(name = "baccept", nullable = true)
    public Date getBaccept() {
        return baccept;
    }

    public void setBaccept(Date baccept) {
        this.baccept = baccept;
    }

    @Basic
    @Column(name = "empid", nullable = true)
    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backlog backlog = (Backlog) o;
        return Objects.equals(blid, backlog.blid) &&
                Objects.equals(btetle, backlog.btetle) &&
                Objects.equals(bianhao, backlog.bianhao) &&
                Objects.equals(bcondition, backlog.bcondition) &&
                Objects.equals(baccept, backlog.baccept) &&
                Objects.equals(empid, backlog.empid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blid, btetle, bianhao, bcondition, baccept, empid);
    }

    @OneToOne(mappedBy = "mybacklog")
    public Approval getMyapproval() {
        return myapproval;
    }

    public void setMyapproval(Approval myapproval) {
        this.myapproval = myapproval;
    }
}
