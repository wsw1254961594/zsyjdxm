package com.study.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Positive {
    private Integer pvid;
    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Timestamp pdate;
    private String prequire;
    private String ptitle;
    private Emp myemp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pvid", nullable = false)
    public Integer getPvid() {
        return pvid;
    }

    public void setPvid(Integer pvid) {
        this.pvid = pvid;
    }

    @Basic
    @Column(name = "pdate", nullable = true)
    public Timestamp getPdate() {
        return pdate;
    }

    public void setPdate(Timestamp pdate) {
        this.pdate = pdate;
    }

    @Basic
    @Column(name = "prequire", nullable = true, length = 255)
    public String getPrequire() {
        return prequire;
    }

    public void setPrequire(String prequire) {
        this.prequire = prequire;
    }

    @Basic
    @Column(name = "ptitle", nullable = true, length = 255)
    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive = (Positive) o;
        return Objects.equals(pvid, positive.pvid) &&
                Objects.equals(pdate, positive.pdate) &&
                Objects.equals(prequire, positive.prequire) &&
                Objects.equals(ptitle, positive.ptitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pvid, pdate, prequire, ptitle);
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
