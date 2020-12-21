package com.study.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Jobmsg {
    private Integer jmid;
    private String jmname;
    private Emp emps;
    private Job myjob;

    @Id
    @Column(name = "jmid", nullable = false)
    public Integer getJmid() {
        return jmid;
    }

    public void setJmid(Integer jmid) {
        this.jmid = jmid;
    }

    @Basic
    @Column(name = "jmname", nullable = true, length = 200)
    public String getJmname() {
        return jmname;
    }

    public void setJmname(String jmname) {
        this.jmname = jmname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jobmsg jobmsg = (Jobmsg) o;
        return Objects.equals(jmid, jobmsg.jmid) &&
                Objects.equals(jmname, jobmsg.jmname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jmid, jmname);
    }

    @OneToOne(mappedBy = "myjobmsg")
    public Emp getEmps() {
        return emps;
    }

    public void setEmps(Emp emps) {
        this.emps = emps;
    }

    @ManyToOne
    @JoinColumn(name = "jid", referencedColumnName = "jid")
    public Job getMyjob() {
        return myjob;
    }

    public void setMyjob(Job myjob) {
        this.myjob = myjob;
    }
}
