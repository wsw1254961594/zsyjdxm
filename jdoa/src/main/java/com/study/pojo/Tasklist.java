package com.study.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Tasklist {
    private Integer tid;
    private String mname;
    private String stage;
    private Date startingtime;
    private Date endtime;
    private Date actualstarttime;
    private Date actualendtime;
    private String schedule;
    private String taskdescription;
    private Itemlist myitemlist;

    @Id
    @Column(name = "tid", nullable = false)
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "mname", nullable = true, length = 200)
    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Basic
    @Column(name = "stage", nullable = true, length = 200)
    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @Basic
    @Column(name = "startingtime", nullable = true)
    public Date getStartingtime() {
        return startingtime;
    }

    public void setStartingtime(Date startingtime) {
        this.startingtime = startingtime;
    }

    @Basic
    @Column(name = "endtime", nullable = true)
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "actualstarttime", nullable = true)
    public Date getActualstarttime() {
        return actualstarttime;
    }

    public void setActualstarttime(Date actualstarttime) {
        this.actualstarttime = actualstarttime;
    }

    @Basic
    @Column(name = "actualendtime", nullable = true)
    public Date getActualendtime() {
        return actualendtime;
    }

    public void setActualendtime(Date actualendtime) {
        this.actualendtime = actualendtime;
    }

    @Basic
    @Column(name = "schedule", nullable = true, length = 200)
    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Basic
    @Column(name = "taskdescription", nullable = true, length = 200)
    public String getTaskdescription() {
        return taskdescription;
    }

    public void setTaskdescription(String taskdescription) {
        this.taskdescription = taskdescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasklist tasklist = (Tasklist) o;
        return Objects.equals(tid, tasklist.tid) &&
                Objects.equals(mname, tasklist.mname) &&
                Objects.equals(stage, tasklist.stage) &&
                Objects.equals(startingtime, tasklist.startingtime) &&
                Objects.equals(endtime, tasklist.endtime) &&
                Objects.equals(actualstarttime, tasklist.actualstarttime) &&
                Objects.equals(actualendtime, tasklist.actualendtime) &&
                Objects.equals(schedule, tasklist.schedule) &&
                Objects.equals(taskdescription, tasklist.taskdescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, mname, stage, startingtime, endtime, actualstarttime, actualendtime, schedule, taskdescription);
    }

    @ManyToOne
    @JoinColumn(name = "iid", referencedColumnName = "iid")
    public Itemlist getMyitemlist() {
        return myitemlist;
    }

    public void setMyitemlist(Itemlist myitemlist) {
        this.myitemlist = myitemlist;
    }
}
