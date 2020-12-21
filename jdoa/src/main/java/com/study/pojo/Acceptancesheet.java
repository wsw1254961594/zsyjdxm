package com.study.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Acceptancesheet {
    private Integer piid;
    private String pname;
    private String approvalstatus;
    private Itemlist myitemlist;

    @Id
    @Column(name = "piid", nullable = false)
    public Integer getPiid() {
        return piid;
    }

    public void setPiid(Integer piid) {
        this.piid = piid;
    }

    @Basic
    @Column(name = "pname", nullable = true, length = 255)
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Basic
    @Column(name = "approvalstatus", nullable = true, length = 255)
    public String getApprovalstatus() {
        return approvalstatus;
    }

    public void setApprovalstatus(String approvalstatus) {
        this.approvalstatus = approvalstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acceptancesheet that = (Acceptancesheet) o;
        return Objects.equals(piid, that.piid) &&
                Objects.equals(pname, that.pname) &&
                Objects.equals(approvalstatus, that.approvalstatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(piid, pname, approvalstatus);
    }

    @OneToOne
    @JoinColumn(name = "iid", referencedColumnName = "iid")
    public Itemlist getMyitemlist() {
        return myitemlist;
    }

    public void setMyitemlist(Itemlist myitemlist) {
        this.myitemlist = myitemlist;
    }
}
