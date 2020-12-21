package com.study.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Empconract {
    private Integer ecid;
    private String ecman;
    private String ectitle;
    private Date startday;
    private Date expirday;
    private Integer state;
    private Emp myemp;

    @Id
    @Column(name = "ecid", nullable = false)
    public Integer getEcid() {
        return ecid;
    }

    public void setEcid(Integer ecid) {
        this.ecid = ecid;
    }

    @Basic
    @Column(name = "ecman", nullable = true, length = 200)
    public String getEcman() {
        return ecman;
    }

    public void setEcman(String ecman) {
        this.ecman = ecman;
    }

    @Basic
    @Column(name = "ectitle", nullable = true, length = 200)
    public String getEctitle() {
        return ectitle;
    }

    public void setEctitle(String ectitle) {
        this.ectitle = ectitle;
    }

    @Basic
    @Column(name = "startday", nullable = true)
    public Date getStartday() {
        return startday;
    }

    public void setStartday(Date startday) {
        this.startday = startday;
    }

    @Basic
    @Column(name = "expirday", nullable = true)
    public Date getExpirday() {
        return expirday;
    }

    public void setExpirday(Date expirday) {
        this.expirday = expirday;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empconract that = (Empconract) o;
        return Objects.equals(ecid, that.ecid) &&
                Objects.equals(ecman, that.ecman) &&
                Objects.equals(ectitle, that.ectitle) &&
                Objects.equals(startday, that.startday) &&
                Objects.equals(expirday, that.expirday) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ecid, ecman, ectitle, startday, expirday, state);
    }

    @OneToOne
    @JoinColumn(name = "empno", referencedColumnName = "empno")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }
}
