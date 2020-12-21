package com.study.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Productcg {
    private Integer pcid;
    private String pcname;
    private String specification;
    private String unit;
    private BigDecimal price;
    private List<Purchaseinfo> purchaseinfos;

    @Id
    @Column(name = "pcid", nullable = false)
    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    @Basic
    @Column(name = "pcname", nullable = true, length = 255)
    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname;
    }

    @Basic
    @Column(name = "specification", nullable = true, length = 200)
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Basic
    @Column(name = "unit", nullable = true, length = 200)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productcg productcg = (Productcg) o;
        return Objects.equals(pcid, productcg.pcid) &&
                Objects.equals(pcname, productcg.pcname) &&
                Objects.equals(specification, productcg.specification) &&
                Objects.equals(unit, productcg.unit) &&
                Objects.equals(price, productcg.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pcid, pcname, specification, unit, price);
    }

    @OneToMany(mappedBy = "myproductcg")
    public List<Purchaseinfo> getPurchaseinfos() {
        return purchaseinfos;
    }

    public void setPurchaseinfos(List<Purchaseinfo> purchaseinfos) {
        this.purchaseinfos = purchaseinfos;
    }
}
