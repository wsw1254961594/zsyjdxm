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
public class Productxs {
    private Integer pxid;
    private String pxnmae;
    private String specification;
    private String unit;
    private BigDecimal price;
    private List<Marketinfo> marketinfos;

    @Id
    @Column(name = "pxid", nullable = false)
    public Integer getPxid() {
        return pxid;
    }

    public void setPxid(Integer pxid) {
        this.pxid = pxid;
    }

    @Basic
    @Column(name = "pxnmae", nullable = true, length = 255)
    public String getPxnmae() {
        return pxnmae;
    }

    public void setPxnmae(String pxnmae) {
        this.pxnmae = pxnmae;
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
        Productxs productxs = (Productxs) o;
        return Objects.equals(pxid, productxs.pxid) &&
                Objects.equals(pxnmae, productxs.pxnmae) &&
                Objects.equals(specification, productxs.specification) &&
                Objects.equals(unit, productxs.unit) &&
                Objects.equals(price, productxs.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pxid, pxnmae, specification, unit, price);
    }

    @OneToMany(mappedBy = "myproductxs")
    public List<Marketinfo> getMarketinfos() {
        return marketinfos;
    }

    public void setMarketinfos(List<Marketinfo> marketinfos) {
        this.marketinfos = marketinfos;
    }
}
