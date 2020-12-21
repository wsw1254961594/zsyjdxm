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
public class Dimission {
    private Integer did;
    private Date ddate;
    private String dcause;
    private Emp myemp;

    @Id
    @Column(name = "did", nullable = false)
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Basic
    @Column(name = "ddate", nullable = true)
    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    @Basic
    @Column(name = "dcause", nullable = true, length = 255)
    public String getDcause() {
        return dcause;
    }

    public void setDcause(String dcause) {
        this.dcause = dcause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimission dimission = (Dimission) o;
        return Objects.equals(did, dimission.did) &&
                Objects.equals(ddate, dimission.ddate) &&
                Objects.equals(dcause, dimission.dcause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, ddate, dcause);
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
