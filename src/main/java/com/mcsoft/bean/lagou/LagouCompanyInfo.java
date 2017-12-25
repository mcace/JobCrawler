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
 * 拉勾网公司信息实体类
 * Created by Mc on 2017/12/20.
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "lagou_company_info")
public class LagouCompanyInfo implements DBModel{
    @Id
    @Column(name = "companyId")
    private int companyId;
    @Column(name = "companyFullName")
    private String companyFullName;
    @Column(name = "companyShortName")
    private String companyShortName;
    @Column(name = "companyLabelList")
    private String companyLabelList;
    @Column(name = "companySize")
    private String companySize;
    @Column(name = "companyLogo")
    private String companyLogo;
    @Column(name = "companyHref")
    private String companyHref;
    @Column(name = "district")
    private String district;
    @Column(name = "businessZones")
    private String businessZones;
    @Column(name = "financeStage")
    private String financeStage;
    @Column(name = "industryField")
    private String industryField;
    @Column(name = "industryLabels")
    private String industryLabels;
    @Column(name = "lineStation")
    private String lineStation;
    @Column(name = "subwayLine")
    private String subwayLine;
    @Column(name = "stationName")
    private String stationName;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    public String getCompanyLabelList() {
        return companyLabelList;
    }

    public void setCompanyLabelList(String companyLabelList) {
        this.companyLabelList = companyLabelList;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyHref() {
        return companyHref;
    }

    public void setCompanyHref(String companyHref) {
        this.companyHref = companyHref;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBusinessZones() {
        return businessZones;
    }

    public void setBusinessZones(String businessZones) {
        this.businessZones = businessZones;
    }

    public String getFinanceStage() {
        return financeStage;
    }

    public void setFinanceStage(String financeStage) {
        this.financeStage = financeStage;
    }

    public String getIndustryField() {
        return industryField;
    }

    public void setIndustryField(String industryField) {
        this.industryField = industryField;
    }

    public String getIndustryLabels() {
        return industryLabels;
    }

    public void setIndustryLabels(String industryLabels) {
        this.industryLabels = industryLabels;
    }

    public String getLineStation() {
        return lineStation;
    }

    public void setLineStation(String lineStation) {
        this.lineStation = lineStation;
    }

    public String getSubwayLine() {
        return subwayLine;
    }

    public void setSubwayLine(String subwayLine) {
        this.subwayLine = subwayLine;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public Serializable getId() {
        return this.companyId;
    }
}
