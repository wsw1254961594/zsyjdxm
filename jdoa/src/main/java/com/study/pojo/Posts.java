package com.study.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Posts {
    private Integer postid;
    private String pcause;
    private Integer yuanpost;
    private Integer xinpost;
    private Integer yuandept;
    private Integer xindept;
    private Integer yuanmgr;
    private Integer xinmgr;
    private String title;
    private Emp myemp;

    @Id
    @Column(name = "postid", nullable = false)
    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    @Basic
    @Column(name = "pcause", nullable = true, length = 255)
    public String getPcause() {
        return pcause;
    }

    public void setPcause(String pcause) {
        this.pcause = pcause;
    }

    @Basic
    @Column(name = "yuanpost", nullable = true)
    public Integer getYuanpost() {
        return yuanpost;
    }

    public void setYuanpost(Integer yuanpost) {
        this.yuanpost = yuanpost;
    }

    @Basic
    @Column(name = "xinpost", nullable = true)
    public Integer getXinpost() {
        return xinpost;
    }

    public void setXinpost(Integer xinpost) {
        this.xinpost = xinpost;
    }

    @Basic
    @Column(name = "yuandept", nullable = true)
    public Integer getYuandept() {
        return yuandept;
    }

    public void setYuandept(Integer yuandept) {
        this.yuandept = yuandept;
    }

    @Basic
    @Column(name = "xindept", nullable = true)
    public Integer getXindept() {
        return xindept;
    }

    public void setXindept(Integer xindept) {
        this.xindept = xindept;
    }

    @Basic
    @Column(name = "yuanmgr", nullable = true)
    public Integer getYuanmgr() {
        return yuanmgr;
    }

    public void setYuanmgr(Integer yuanmgr) {
        this.yuanmgr = yuanmgr;
    }

    @Basic
    @Column(name = "xinmgr", nullable = true)
    public Integer getXinmgr() {
        return xinmgr;
    }

    public void setXinmgr(Integer xinmgr) {
        this.xinmgr = xinmgr;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 200)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts posts = (Posts) o;
        return Objects.equals(postid, posts.postid) &&
                Objects.equals(pcause, posts.pcause) &&
                Objects.equals(yuanpost, posts.yuanpost) &&
                Objects.equals(xinpost, posts.xinpost) &&
                Objects.equals(yuandept, posts.yuandept) &&
                Objects.equals(xindept, posts.xindept) &&
                Objects.equals(yuanmgr, posts.yuanmgr) &&
                Objects.equals(xinmgr, posts.xinmgr) &&
                Objects.equals(title, posts.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postid, pcause, yuanpost, xinpost, yuandept, xindept, yuanmgr, xinmgr, title);
    }

    @ManyToOne
    @JoinColumn(name = "empno", referencedColumnName = "empno")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }
}
