package com.study.vo;

import java.util.Date;

/**
 * @Author: timelinbao
 * @Description:
 * @Date: create in 2020/12/23 15:15
 */
public class Tasklists {

    private Integer tid;
    private Integer iid;
    private String mname;
    private String stage;
    private Date startingtime;
    private Date endtime;
    private Date actualstarttime;
    private Date actualendtime;
    private String schedule;
    private String taskdescription;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
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

    @Override
    public String toString() {
        return "Tasklist{" +
                "tid=" + tid +
                ", iid=" + iid +
                ", mname='" + mname + '\'' +
                ", stage='" + stage + '\'' +
                ", startingtime=" + startingtime +
                ", endtime=" + endtime +
                ", actualstarttime=" + actualstarttime +
                ", actualendtime=" + actualendtime +
                ", schedule='" + schedule + '\'' +
                ", taskdescription='" + taskdescription + '\'' +
                '}';
    }

    public Tasklists() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Tasklists(Integer tid,Integer iid, String mname, String stage, Date startingtime,
                    Date endtime, Date actualstarttime, Date actualendtime,
                    String schedule, String taskdescription){
        super();
        this.tid = tid;
        this.iid = iid;
        this.mname = mname;
        this.stage = stage;
        this.startingtime = startingtime;
        this.endtime = endtime;
        this.actualstarttime = actualstarttime;
        this.actualendtime = actualendtime;
        this.schedule = schedule;
        this.taskdescription = taskdescription;
    }
}
