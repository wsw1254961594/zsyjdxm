package com.study.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Job {
    private Integer jid;
    private String jname;
    private Dept mydept;
    private List<Jobmsg> jobmsgs;

    @Id
    @Column(name = "jid", nullable = false)
    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    @Basic
    @Column(name = "jname", nullable = true, length = 200)
    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(jid, job.jid) &&
                Objects.equals(jname, job.jname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jid, jname);
    }

    @ManyToOne
    @JoinColumn(name = "deptno", referencedColumnName = "deptno")
    public Dept getMydept() {
        return mydept;
    }

    public void setMydept(Dept mydept) {
        this.mydept = mydept;
    }

    @OneToMany(mappedBy = "myjob")
    public List<Jobmsg> getJobmsgs() {
        return jobmsgs;
    }

    public void setJobmsgs(List<Jobmsg> jobmsgs) {
        this.jobmsgs = jobmsgs;
    }
}
