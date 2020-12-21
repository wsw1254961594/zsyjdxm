package com.study.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Shiyong {
    private Integer xqid;
    private String zt;
    private Xiangqing myxiangqing;

    @Id
    @Column(name = "xqid", nullable = false)
    public Integer getXqid() {
        return xqid;
    }

    public void setXqid(Integer xqid) {
        this.xqid = xqid;
    }

    @Basic
    @Column(name = "zt", nullable = true, length = 200)
    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shiyong shiyong = (Shiyong) o;
        return Objects.equals(xqid, shiyong.xqid) &&
                Objects.equals(zt, shiyong.zt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xqid, zt);
    }

    @OneToOne
    @JoinColumn(name = "hydzid", referencedColumnName = "hydzid")
    public Xiangqing getMyxiangqing() {
        return myxiangqing;
    }

    public void setMyxiangqing(Xiangqing myxiangqing) {
        this.myxiangqing = myxiangqing;
    }
}
