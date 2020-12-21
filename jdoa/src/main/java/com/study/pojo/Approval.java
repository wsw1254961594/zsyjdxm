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
public class Approval {
    private Integer apid;
    private Integer result;
    private String opinion;
    private Date sdate;
    private Backlog mybacklog;

    @Id
    @Column(name = "apid", nullable = false)
    public Integer getApid() {
        return apid;
    }

    public void setApid(Integer apid) {
        this.apid = apid;
    }

    @Basic
    @Column(name = "result", nullable = true)
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Basic
    @Column(name = "opinion", nullable = true, length = 200)
    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    @Basic
    @Column(name = "sdate", nullable = true)
    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Approval approval = (Approval) o;
        return Objects.equals(apid, approval.apid) &&
                Objects.equals(result, approval.result) &&
                Objects.equals(opinion, approval.opinion) &&
                Objects.equals(sdate, approval.sdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apid, result, opinion, sdate);
    }

    @OneToOne
    @JoinColumn(name = "blid", referencedColumnName = "blid")
    public Backlog getMybacklog() {
        return mybacklog;
    }

    public void setMybacklog(Backlog mybacklog) {
        this.mybacklog = mybacklog;
    }
}
