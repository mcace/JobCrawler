package com.mcsoft.bean.lagou;

import com.mcsoft.bean.DBModel;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 拉勾网职位详情实体类
 * Created by Mc on 2017/12/20.
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "lagou_position_detail")
public class LagouPositionDetail implements DBModel {
    @Id
    @Column(name = "positionId")
    private int positionId;
    @Column(name = "companyId")
    private int companyId;
    @Column(name = "createTime")
    private String createTime;
    @Column(name = "city")
    private String city;
    @Column(name = "company")
    private String company;
    @Column(name = "education")
    private String education;
    @Column(name = "positionName")
    private String positionName;
    @Column(name = "positionAdvantage")
    private String positionAdvantage;
    @Column(name = "positionDescription")
    private String positionDescription;
    @Column(name = "positionAddress")
    private String positionAddress;
    @Column(name = "positionLabels")
    private String positionLabels;
    @Column(name = "firstType")
    private String firstType;
    @Column(name = "secondType")
    private String secondType;
    @Column(name = "positionNature")
    private String positionNature;
    @Column(name = "salary")
    private String salary;
    @Column(name = "workYear")
    private String workYear;

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionAdvantage() {
        return positionAdvantage;
    }

    public void setPositionAdvantage(String positionAdvantage) {
        this.positionAdvantage = positionAdvantage;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public String getPositionAddress() {
        return positionAddress;
    }

    public void setPositionAddress(String positionAddress) {
        this.positionAddress = positionAddress;
    }

    public String getPositionLabels() {
        return positionLabels;
    }

    public void setPositionLabels(String positionLabels) {
        this.positionLabels = positionLabels;
    }

    public String getFirstType() {
        return firstType;
    }

    public void setFirstType(String firstType) {
        this.firstType = firstType;
    }

    public String getSecondType() {
        return secondType;
    }

    public void setSecondType(String secondType) {
        this.secondType = secondType;
    }

    public String getPositionNature() {
        return positionNature;
    }

    public void setPositionNature(String positionNature) {
        this.positionNature = positionNature;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    @Override
    public Serializable getId() {
        return this.positionId;
    }
}
