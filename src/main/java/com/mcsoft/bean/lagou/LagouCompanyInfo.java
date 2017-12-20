package com.mcsoft.bean.lagou;

import com.mcsoft.bean.DBModel;

import java.io.Serializable;

/**
 * 拉勾网公司信息实体类
 * Created by Mc on 2017/12/20.
 */
public class LagouCompanyInfo implements DBModel{
    private int companyId;
    private String companyFullName;
    private String companyShortName;
    private String companyLabelList;
    private String companySize;
    private String companyLogo;
    private String companyHref;
    private String district;
    private String businessZones;
    private String financeStage;
    private String industryField;
    private String industryLables;
    private String lineStation;
    private String subwayLine;
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

    public String getIndustryLables() {
        return industryLables;
    }

    public void setIndustryLables(String industryLables) {
        this.industryLables = industryLables;
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
