package com.study.vo;

import java.util.Date;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/23 16:38
 */
public class ItemTask {
    private Integer tid;
    private String mname;
    private String stage;
    private Date startingtime;
    private Date endtime;
    private Date actualstarttime;
    private Date actualendtime;
    private String schedule;
    private String taskdescription;
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

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Date getStartingtime() {
        return startingtime;
    }

    public void setStartingtime(Date startingtime) {
        this.startingtime = startingtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getActualstarttime() {
        return actualstarttime;
    }

    public void setActualstarttime(Date actualstarttime) {
        this.actualstarttime = actualstarttime;
    }

    public Date getActualendtime() {
        return actualendtime;
    }

    public void setActualendtime(Date actualendtime) {
        this.actualendtime = actualendtime;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTaskdescription() {
        return taskdescription;
    }

    public void setTaskdescription(String taskdescription) {
        this.taskdescription = taskdescription;
    }


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
        return "ItemTask{" +
                "tid=" + tid +
                ", mname='" + mname + '\'' +
                ", stage='" + stage + '\'' +
                ", startingtime=" + startingtime +
                ", endtime=" + endtime +
                ", actualstarttime=" + actualstarttime +
                ", actualendtime=" + actualendtime +
                ", schedule='" + schedule + '\'' +
                ", taskdescription='" + taskdescription + '\'' +
                ", iid=" + iid +
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

    public ItemTask(){
        super();
    }


}
