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
public class Assets {
    private Integer aid;
    private String aserial;
    private String aname;
    private String amodel;
    private String agroup;
    private List<Asset> assets;

    @Id
    @Column(name = "aid", nullable = false)
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "aserial", nullable = true, length = 200)
    public String getAserial() {
        return aserial;
    }

    public void setAserial(String aserial) {
        this.aserial = aserial;
    }

    @Basic
    @Column(name = "aname", nullable = true, length = 200)
    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Basic
    @Column(name = "amodel", nullable = true, length = 200)
    public String getAmodel() {
        return amodel;
    }

    public void setAmodel(String amodel) {
        this.amodel = amodel;
    }

    @Basic
    @Column(name = "agroup", nullable = true, length = 200)
    public String getAgroup() {
        return agroup;
    }

    public void setAgroup(String agroup) {
        this.agroup = agroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assets assets = (Assets) o;
        return Objects.equals(aid, assets.aid) &&
                Objects.equals(aserial, assets.aserial) &&
                Objects.equals(aname, assets.aname) &&
                Objects.equals(amodel, assets.amodel) &&
                Objects.equals(agroup, assets.agroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid, aserial, aname, amodel, agroup);
    }

    @OneToMany(mappedBy = "myassets")
    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
}
