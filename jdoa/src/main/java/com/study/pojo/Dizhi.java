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
public class Dizhi {
    private Integer dzid;
    private String leixingname;
    private String hyzt;
    private List<Xiangqing> xiangqings;

    @Id
    @Column(name = "dzid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getDzid() {
        return dzid;
    }

    public void setDzid(Integer dzid) {
        this.dzid = dzid;
    }

    @Basic
    @Column(name = "leixingname", nullable = true, length = 200)
    public String getLeixingname() {
        return leixingname;
    }

    public void setLeixingname(String leixingname) {
        this.leixingname = leixingname;
    }

    @Basic
    @Column(name = "hyzt", nullable = true, length = 200)
    public String getHyzt() {
        return hyzt;
    }

    public void setHyzt(String hyzt) {
        this.hyzt = hyzt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dizhi dizhi = (Dizhi) o;
        return Objects.equals(dzid, dizhi.dzid) &&
                Objects.equals(leixingname, dizhi.leixingname) &&
                Objects.equals(hyzt, dizhi.hyzt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dzid, leixingname, hyzt);
    }

    @OneToMany(mappedBy = "mydizhi")
    public List<Xiangqing> getXiangqings() {
        return xiangqings;
    }

    public void setXiangqings(List<Xiangqing> xiangqings) {
        this.xiangqings = xiangqings;
    }
}
