package com.study.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @Author: TianMing
 * @Description:
 * @Date: create in 2020/12/22 10:15
 */
@Entity
public class Huiyirenyuan {
    private Integer ehid;
    private Emp empsss;
    private Xiangqing xian;

    public Huiyirenyuan() {
    }

    public Huiyirenyuan(Integer ehid, Emp empsss, Xiangqing xian) {
        this.ehid = ehid;
        this.empsss = empsss;
        this.xian = xian;
    }

    @Override
    public String toString() {
        return "Huiyirenyuan{" +
                "ehid=" + ehid +
                ", empsss=" + empsss +
                ", xian=" + xian +
                '}';
    }

    @Id
    @Column(name = "ehid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getEhid() {
        return ehid;
    }

    public void setEhid(Integer ehid) {
        this.ehid = ehid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Huiyirenyuan that = (Huiyirenyuan) o;
        return Objects.equals(ehid, that.ehid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ehid);
    }

    @ManyToOne
    @JoinColumn(name = "empno", referencedColumnName = "empno", nullable = false)
    public Emp getEmpsss() {
        return empsss;
    }

    public void setEmpsss(Emp empsss) {
        this.empsss = empsss;
    }

    @ManyToOne
    @JoinColumn(name = "hydzid", referencedColumnName = "hydzid", nullable = false)
    public Xiangqing getXian() {
        return xian;
    }

    public void setXian(Xiangqing xian) {
        this.xian = xian;
    }


}
