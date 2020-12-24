package com.study.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/24 9:31
 */
@Entity
public class Contractchange {
    private Integer chid;
    private String chtitle;
    private String chcause;
    private Date chday;
    private String chtype;
    private Integer chstate;
    private Contract mycontract;
    private Emp myemp;

    public Contractchange() {
    }

    public Contractchange(Integer chid, String chtitle, String chcause, Date chday, String chtype, Integer chstate, Contract mycontract, Emp myemp) {
        this.chid = chid;
        this.chtitle = chtitle;
        this.chcause = chcause;
        this.chday = chday;
        this.chtype = chtype;
        this.chstate = chstate;
        this.mycontract = mycontract;
        this.myemp = myemp;
    }

    @Id
    @Column(name = "chid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getChid() {
        return chid;
    }

    public void setChid(Integer chid) {
        this.chid = chid;
    }

    @Basic
    @Column(name = "chtitle", nullable = true, length = 255)
    public String getChtitle() {
        return chtitle;
    }

    public void setChtitle(String chtitle) {
        this.chtitle = chtitle;
    }

    @Basic
    @Column(name = "chcause", nullable = true, length = 255)
    public String getChcause() {
        return chcause;
    }

    public void setChcause(String chcause) {
        this.chcause = chcause;
    }

    @Basic
    @Column(name = "chday", nullable = true)
    public Date getChday() {
        return chday;
    }

    public void setChday(Date chday) {
        this.chday = chday;
    }

    @Basic
    @Column(name = "chtype", nullable = true)
    public String getChtype() {
        return chtype;
    }

    public void setChtype(String chtype) {
        this.chtype = chtype;
    }

    @Basic
    @Column(name = "chstate", nullable = true)
    public Integer getChstate() {
        return chstate;
    }

    public void setChstate(Integer chstate) {
        this.chstate = chstate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contractchange that = (Contractchange) o;
        return Objects.equals(chid, that.chid) &&
                Objects.equals(chtitle, that.chtitle) &&
                Objects.equals(chcause, that.chcause) &&
                Objects.equals(chday, that.chday) &&
                Objects.equals(chtype, that.chtype) &&
                Objects.equals(chstate, that.chstate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chid, chtitle, chcause, chday, chtype, chstate);
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
    @JoinColumn(name = "empno", referencedColumnName = "empno")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }
}
