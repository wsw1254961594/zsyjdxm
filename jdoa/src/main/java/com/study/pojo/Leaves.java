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
public class Leaves {
    private Integer lid;
    private Timestamp lbegin;
    private Timestamp ifinish;
    private String lreason;
    private String ltitle;
    private String itype;
    private Emp myemp;

    @Id
    @Column(name = "lid", nullable = false)
    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    @Basic
    @Column(name = "lbegin", nullable = true)
    public Timestamp getLbegin() {
        return lbegin;
    }

    public void setLbegin(Timestamp lbegin) {
        this.lbegin = lbegin;
    }

    @Basic
    @Column(name = "ifinish", nullable = true)
    public Timestamp getIfinish() {
        return ifinish;
    }

    public void setIfinish(Timestamp ifinish) {
        this.ifinish = ifinish;
    }

    @Basic
    @Column(name = "lreason", nullable = true, length = 255)
    public String getLreason() {
        return lreason;
    }

    public void setLreason(String lreason) {
        this.lreason = lreason;
    }

    @Basic
    @Column(name = "ltitle", nullable = true, length = 255)
    public String getLtitle() {
        return ltitle;
    }

    public void setLtitle(String ltitle) {
        this.ltitle = ltitle;
    }

    @Basic
    @Column(name = "itype", nullable = true, length = 200)
    public String getItype() {
        return itype;
    }

    public void setItype(String itype) {
        this.itype = itype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaves leaves = (Leaves) o;
        return Objects.equals(lid, leaves.lid) &&
                Objects.equals(lbegin, leaves.lbegin) &&
                Objects.equals(ifinish, leaves.ifinish) &&
                Objects.equals(lreason, leaves.lreason) &&
                Objects.equals(ltitle, leaves.ltitle) &&
                Objects.equals(itype, leaves.itype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lid, lbegin, ifinish, lreason, ltitle, itype);
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
