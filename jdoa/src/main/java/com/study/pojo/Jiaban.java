package com.study.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Jiaban {
    private Integer jnid;
    private Timestamp starttime;
    private Timestamp endtime;
    private String jtype;
    private String jreason;
    private String jtitle;
    private Emp myemp;

    private String starDate;
    private String endDate;

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Id
    @Column(name = "jnid", nullable = false)
    public Integer getJnid() {
        return jnid;
    }

    public void setJnid(Integer jnid) {
        this.jnid = jnid;
    }

    @Basic
    @Column(name = "starttime", nullable = true)
    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    @Basic
    @Column(name = "endtime", nullable = true)
    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "jtype", nullable = true, length = 200)
    public String getJtype() {
        return jtype;
    }

    public void setJtype(String jtype) {
        this.jtype = jtype;
    }

    @Basic
    @Column(name = "jreason", nullable = true, length = 200)
    public String getJreason() {
        return jreason;
    }

    public void setJreason(String jreason) {
        this.jreason = jreason;
    }

    @Basic
    @Column(name = "jtitle", nullable = true, length = 200)
    public String getJtitle() {
        return jtitle;
    }

    public void setJtitle(String jtitle) {
        this.jtitle = jtitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jiaban jiaban = (Jiaban) o;
        return Objects.equals(jnid, jiaban.jnid) &&
                Objects.equals(starttime, jiaban.starttime) &&
                Objects.equals(endtime, jiaban.endtime) &&
                Objects.equals(jtype, jiaban.jtype) &&
                Objects.equals(jreason, jiaban.jreason) &&
                Objects.equals(jtitle, jiaban.jtitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jnid, starttime, endtime, jtype, jreason, jtitle);
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
