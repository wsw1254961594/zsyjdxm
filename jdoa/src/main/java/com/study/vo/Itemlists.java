package com.study.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/22 15:39
 */
public class Itemlists {

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

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getStageof() {
        return stageof;
    }

    public void setStageof(String stageof) {
        this.stageof = stageof;
    }

    public Date getPlanstartdate() {
        return planstartdate;
    }

    public void setPlanstartdate(Date planstartdate) {
        this.planstartdate = planstartdate;
    }

    public Date getPlanenddate() {
        return planenddate;
    }

    public void setPlanenddate(Date planenddate) {
        this.planenddate = planenddate;
    }

    public Date getActualstartdate() {
        return actualstartdate;
    }

    public void setActualstartdate(Date actualstartdate) {
        this.actualstartdate = actualstartdate;
    }

    public Date getActualenddate() {
        return actualenddate;
    }

    public void setActualenddate(Date actualenddate) {
        this.actualenddate = actualenddate;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    @Override
    public String toString() {
        return "Itemlists{" +
                "iid=" + iid +
                ", pname='" + pname + '\'' +
                ", types='" + types + '\'' +
                ", status='" + status + '\'' +
                ", jobtype='" + jobtype + '\'' +
                ", progress='" + progress + '\'' +
                ", stageof='" + stageof + '\'' +
                ", planstartdate=" + planstartdate +
                ", planenddate=" + planenddate +
                ", actualstartdate=" + actualstartdate +
                ", actualenddate=" + actualenddate +
                ", empid=" + empid +
                '}';
    }

    public Itemlists(Integer iid, String pname, String types, String status,
                     String jobtype, String progress, String stageof, Date planstartdate,
               Date planenddate, Date actualstartdate, Date actualenddate, Integer empid) {
        super();
        this.iid = iid;
        this.pname = pname;
        this.types = types;
        this.status = status;
        this.jobtype = jobtype;
        this.progress = progress;
        this.stageof = stageof;
        this.planstartdate = planstartdate;
        this.planenddate = planenddate;
        this.actualstartdate = actualstartdate;
        this.actualenddate = actualenddate;
        this.empid = empid;
    }

    public Itemlists() {
        super();
        // TODO Auto-generated constructor stub
    }

}
