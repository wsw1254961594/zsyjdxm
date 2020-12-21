package com.study.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author: ZhongShangYu
 * @Description:
 * @Date: create in 2020/12/21 14:54
 */
@Entity
public class Personal {
    private Integer pid;
    private String pimg;
    private String speciality;
    private String plike;
    private String mail;
    private Date birthday;
    private String patent;
    private String natives;
    private String idcard;
    private String marital;
    private String politics;
    private String education;
    private String password;
    private String cardimg;
    private Emp myemp;

    @Id
    @Column(name = "pid", nullable = false)
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "pimg", nullable = true, length = 200)
    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    @Basic
    @Column(name = "speciality", nullable = true, length = 200)
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Basic
    @Column(name = "plike", nullable = true, length = 200)
    public String getPlike() {
        return plike;
    }

    public void setPlike(String plike) {
        this.plike = plike;
    }

    @Basic
    @Column(name = "mail", nullable = true, length = 200)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "patent", nullable = true, length = 200)
    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    @Basic
    @Column(name = "natives", nullable = true, length = 200)
    public String getNatives() {
        return natives;
    }

    public void setNatives(String natives) {
        this.natives = natives;
    }

    @Basic
    @Column(name = "idcard", nullable = true, length = 200)
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Basic
    @Column(name = "marital", nullable = true, length = 200)
    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    @Basic
    @Column(name = "politics", nullable = true, length = 200)
    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    @Basic
    @Column(name = "education", nullable = true, length = 200)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "cardimg", nullable = true, length = 200)
    public String getCardimg() {
        return cardimg;
    }

    public void setCardimg(String cardimg) {
        this.cardimg = cardimg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personal personal = (Personal) o;
        return Objects.equals(pid, personal.pid) &&
                Objects.equals(pimg, personal.pimg) &&
                Objects.equals(speciality, personal.speciality) &&
                Objects.equals(plike, personal.plike) &&
                Objects.equals(mail, personal.mail) &&
                Objects.equals(birthday, personal.birthday) &&
                Objects.equals(patent, personal.patent) &&
                Objects.equals(natives, personal.natives) &&
                Objects.equals(idcard, personal.idcard) &&
                Objects.equals(marital, personal.marital) &&
                Objects.equals(politics, personal.politics) &&
                Objects.equals(education, personal.education) &&
                Objects.equals(password, personal.password) &&
                Objects.equals(cardimg, personal.cardimg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, pimg, speciality, plike, mail, birthday, patent, natives, idcard, marital, politics, education, password, cardimg);
    }

    @OneToOne
    @JoinColumn(name = "empno", referencedColumnName = "empno")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }
}
