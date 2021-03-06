package com.study.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Timestamp kaishitimedate;
    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Timestamp jieshutime;
    private String neirong;
    private Dizhi mydizhi;
    private Emp ese;
    private List<Huiyirenyuan> rrr;
    private String hyleixi;
    private Shiyong myshiyong;


    public Xiangqing() {
    }

    public Xiangqing(Integer hydzid, String hyrw, Timestamp kaishitimedate, Timestamp jieshutime, String neirong,String hyleixi, Dizhi mydizhi, Emp ese) {
        this.hydzid = hydzid;
        this.hyrw = hyrw;
        this.kaishitimedate = kaishitimedate;
        this.jieshutime = jieshutime;
        this.neirong = neirong;
        this.hyleixi = hyleixi;
        this.mydizhi = mydizhi;
        this.ese = ese;
    }

    @Override
    public String toString() {
        return "Xiangqing{" +
                "hydzid=" + hydzid +
                ", hyrw='" + hyrw + '\'' +
                ", kaishitimedate=" + kaishitimedate +
                ", jieshutime=" + jieshutime +
                ", neirong='" + neirong + '\'' +
                ", mydizhi=" + mydizhi +
                ", ese=" + ese +
                ", rrr=" + rrr +
                ", hyleixi='" + hyleixi + '\'' +
                ", myshiyong=" + myshiyong +
                '}';
    }

    @Id
    @Column(name = "hydzid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "xian")
    public List<Huiyirenyuan> getRrr() {
        return rrr;
    }

    public void setRrr(List<Huiyirenyuan> rrr) {
        this.rrr = rrr;
    }

    @Basic
    @Column(name = "hyleixi", nullable = true, length = 255)
    public String getHyleixi() {
        return hyleixi;
    }

    public void setHyleixi(String hyleixi) {
        this.hyleixi = hyleixi;
    }


}
