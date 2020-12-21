package com.study.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Xiangqing {
    private Integer hydzid;
    private String hyrw;
    private Timestamp kaishitimedate;
    private Timestamp jieshutime;
    private String neirong;

    private Shiyong myshiyong;
    private List<Emp> emps;
    private Dizhi mydizhi;
    private Emp ese;

    @Id
    @Column(name = "hydzid", nullable = false)
    public Integer getHydzid() {
        return hydzid;
    }

    public void setHydzid(Integer hydzid) {
        this.hydzid = hydzid;
    }

    @Basic
    @Column(name = "hyrw", nullable = true, length = 200)
    public String getHyrw() {
        return hyrw;
    }

    public void setHyrw(String hyrw) {
        this.hyrw = hyrw;
    }

    @Basic
    @Column(name = "kaishitimedate", nullable = true)
    public Timestamp getKaishitimedate() {
        return kaishitimedate;
    }

    public void setKaishitimedate(Timestamp kaishitimedate) {
        this.kaishitimedate = kaishitimedate;
    }

    @Basic
    @Column(name = "jieshutime", nullable = true)
    public Timestamp getJieshutime() {
        return jieshutime;
    }

    public void setJieshutime(Timestamp jieshutime) {
        this.jieshutime = jieshutime;
    }

    @Basic
    @Column(name = "neirong", nullable = true, length = 500)
    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xiangqing xiangqing = (Xiangqing) o;
        return Objects.equals(hydzid, xiangqing.hydzid) &&
                Objects.equals(hyrw, xiangqing.hyrw) &&
                Objects.equals(kaishitimedate, xiangqing.kaishitimedate) &&
                Objects.equals(jieshutime, xiangqing.jieshutime) &&
                Objects.equals(neirong, xiangqing.neirong)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hydzid, hyrw, kaishitimedate, jieshutime, neirong);
    }

    @OneToOne(mappedBy = "myxiangqing")
    public Shiyong getMyshiyong() {
        return myshiyong;
    }

    public void setMyshiyong(Shiyong myshiyong) {
        this.myshiyong = myshiyong;
    }

    @ManyToMany
    @JoinTable(name = "huiyirenyuan", catalog = "", schema = "jdoa", joinColumns = @JoinColumn(name = "hydzid", referencedColumnName = "hydzid", nullable = false), inverseJoinColumns = @JoinColumn(name = "empno", referencedColumnName = "empno", nullable = false))
    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @ManyToOne
    @JoinColumn(name = "dzid", referencedColumnName = "dzid")
    public Dizhi getMydizhi() {
        return mydizhi;
    }

    public void setMydizhi(Dizhi mydizhi) {
        this.mydizhi = mydizhi;
    }

    @ManyToOne
    @JoinColumn(name = "empid", referencedColumnName = "empno")
    public Emp getEse() {
        return ese;
    }

    public void setEse(Emp ese) {
        this.ese = ese;
    }
}
