package com.study.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Itemlist {
    private Integer iid;
    private String pname;
    private String types;
    private String status;
    private String jobtype;
    private String progress;
    private String stageof;
    private Date planstartdate;
    private Date planenddate;
    private Date actualstartdate;
    private Date actualenddate;
    private Integer empid;
    private Acceptancesheet mysheet;
    private List<Emp> emps;
    private List<Tasklist> tasklists;

    @Id
    @Column(name = "iid", nullable = false)
    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    @Basic
    @Column(name = "pname", nullable = true, length = 200)
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Basic
    @Column(name = "types", nullable = true, length = 200)
    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 200)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "jobtype", nullable = true, length = 200)
    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    @Basic
    @Column(name = "progress", nullable = true, length = 200)
    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Basic
    @Column(name = "stageof", nullable = true, length = 200)
    public String getStageof() {
        return stageof;
    }

    public void setStageof(String stageof) {
        this.stageof = stageof;
    }

    @Basic
    @Column(name = "planstartdate", nullable = true)
    public Date getPlanstartdate() {
        return planstartdate;
    }

    public void setPlanstartdate(Date planstartdate) {
        this.planstartdate = planstartdate;
    }

    @Basic
    @Column(name = "planenddate", nullable = true)
    public Date getPlanenddate() {
        return planenddate;
    }

    public void setPlanenddate(Date planenddate) {
        this.planenddate = planenddate;
    }

    @Basic
    @Column(name = "actualstartdate", nullable = true)
    public Date getActualstartdate() {
        return actualstartdate;
    }

    public void setActualstartdate(Date actualstartdate) {
        this.actualstartdate = actualstartdate;
    }

    @Basic
    @Column(name = "actualenddate", nullable = true)
    public Date getActualenddate() {
        return actualenddate;
    }

    public void setActualenddate(Date actualenddate) {
        this.actualenddate = actualenddate;
    }

    @Basic
    @Column(name = "empid", nullable = true)
    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Itemlist itemlist = (Itemlist) o;
        return Objects.equals(iid, itemlist.iid) &&
                Objects.equals(pname, itemlist.pname) &&
                Objects.equals(types, itemlist.types) &&
                Objects.equals(status, itemlist.status) &&
                Objects.equals(jobtype, itemlist.jobtype) &&
                Objects.equals(progress, itemlist.progress) &&
                Objects.equals(stageof, itemlist.stageof) &&
                Objects.equals(planstartdate, itemlist.planstartdate) &&
                Objects.equals(planenddate, itemlist.planenddate) &&
                Objects.equals(actualstartdate, itemlist.actualstartdate) &&
                Objects.equals(actualenddate, itemlist.actualenddate) &&
                Objects.equals(empid, itemlist.empid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, pname, types, status, jobtype, progress, stageof, planstartdate, planenddate, actualstartdate, actualenddate, empid);
    }

    @OneToOne(mappedBy = "myitemlist")
    public Acceptancesheet getMysheet() {
        return mysheet;
    }

    public void setMysheet(Acceptancesheet mysheet) {
        this.mysheet = mysheet;
    }

    @ManyToMany
    @JoinTable(name = "empitem", catalog = "", schema = "jdoa", joinColumns = @JoinColumn(name = "iid", referencedColumnName = "iid", nullable = false), inverseJoinColumns = @JoinColumn(name = "empno", referencedColumnName = "empno", nullable = false))
    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @OneToMany(mappedBy = "myitemlist")
    public List<Tasklist> getTasklists() {
        return tasklists;
    }

    public void setTasklists(List<Tasklist> tasklists) {
        this.tasklists = tasklists;
    }
}
