package com.mcsoft.bean.lagou;

import com.mcsoft.bean.DBModel;

import java.io.Serializable;

/**
 * 拉勾网职位详情实体类
 * Created by Mc on 2017/12/20.
 */
public class LagouPositionDetail implements DBModel{
    private int positionId;
    private int companyId;
    private String company;
    private String education;
    private String positionName;
    private String positionAdvantage;
    private String positionDescription;
    private String positionAddress;
    private String positionLables;
    private String firstType;
    private String secondType;
    private String positionNature;
    private String salary;
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

    public String getPositionLables() {
        return positionLables;
    }

    public void setPositionLables(String positionLables) {
        this.positionLables = positionLables;
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
