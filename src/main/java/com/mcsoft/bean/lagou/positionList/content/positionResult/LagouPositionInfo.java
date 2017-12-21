package com.mcsoft.bean.lagou.positionList.content.positionResult;

import com.mcsoft.bean.DBModel;
import com.mcsoft.utils.BeanUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * 拉勾网Ajax请求响应JSON对应职位信息实体类
 * Created by Mc on 2017/12/8.
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "lagou_position_info")
public class LagouPositionInfo implements DBModel {
    @Column(name = "companyId")
    private Integer companyId;
    @Column(name = "positionName")
    private String positionName;
    @Column(name = "workYear")
    private String workYear;
    @Column(name = "education")
    private String education;
    @Column(name = "jobNature")
    private String jobNature;
    @Column(name = "financeStage")
    private String financeStage;
    @Column(name = "companyLogo")
    private String companyLogo;
    @Column(name = "industryField")
    private String industryField;
    @Column(name = "city")
    private String city;
    @Column(name = "salary")
    private String salary;
    @Id
    @Column(name = "positionId")
    private Integer positionId;
    @Column(name = "positionAdvantage")
    private String positionAdvantage;
    @Column(name = "companyShortName")
    private String companyShortName;
    @Column(name = "district")
    private String district;
    @Column(name = "createTime")
    private String createTime;
    @Column(name = "score")
    private Integer score;
    @Column(name = "approve")
    private Integer approve;
    @Column(name = "positionLabels")
    //private String[] positionLabels;
    private String positionLabels;
    @Column(name = "industryLabels")
    //private String[] industryLabels;
    private String industryLabels;
    @Column(name = "publisherId")
    private Integer publisherId;
    @Column(name = "companyLabelList")
    //private String[] companyLabelList;
    private String companyLabelList;
    @Column(name = "companySize")
    private String companySize;
    @Column(name = "businessZones")
    private String businessZones;
    @Column(name = "Longitude")
    private String Longitude;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "companyFullName")
    private String companyFullName;
    @Column(name = "adWord")
    private Integer adWord;
    @Column(name = "formatCreateTime")
    private String formatCreateTime;
    @Column(name = "imState")
    private String imState;
    @Column(name = "lastLogin")
    private Long lastLogin;
    @Column(name = "explain_str")
    private String explain;
    @Column(name = "plus")
    private String plus;
    @Column(name = "pcShow")
    private Integer pcShow;
    @Column(name = "appShow")
    private Integer appShow;
    @Column(name = "deliver")
    private Integer deliver;
    @Column(name = "gradeDescription")
    private String gradeDescription;
    @Column(name = "promotionScoreExplain")
    private String promotionScoreExplain;
    @Column(name = "firstType")
    private String firstType;
    @Column(name = "secondType")
    private String secondType;
    @Column(name = "isSchoolJob")
    private Integer isSchoolJob;
    @Column(name = "subwayline")
    private String subwayline;
    @Column(name = "stationname")
    private String stationname;
    @Column(name = "linestaion")
    private String linestaion;
    @Column(name = "processed")
    private Integer processed = 0;

    public LagouPositionInfo() {
        //setDefault();
    }

    private void setDefault() {
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                if (field.getType() == String.class) {
                    field.setAccessible(true);
                    field.set(this, "");
                } else if (field.getType() == Integer.class) {
                    field.setAccessible(true);
                    field.set(this, 0);
                } else if (field.getType() == Long.class) {
                    field.setAccessible(true);
                    field.set(this, 0L);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature;
    }

    public String getFinanceStage() {
        return financeStage;
    }

    public void setFinanceStage(String financeStage) {
        this.financeStage = financeStage;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getIndustryField() {
        return industryField;
    }

    public void setIndustryField(String industryField) {
        this.industryField = industryField;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionAdvantage() {
        return positionAdvantage;
    }

    public void setPositionAdvantage(String positionAdvantage) {
        this.positionAdvantage = positionAdvantage;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getApprove() {
        return approve;
    }

    public void setApprove(Integer approve) {
        this.approve = approve;
    }

    public String getPositionLabels() {
        return positionLabels;
    }

    public void setPositionLabels(String positionLabels) {
        this.positionLabels = positionLabels;
    }

    public String getIndustryLabels() {
        return industryLabels;
    }

    public void setIndustryLabels(String industryLabels) {
        this.industryLabels = industryLabels;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
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

    public String getBusinessZones() {
        return businessZones;
    }

    public void setBusinessZones(String businessZones) {
        this.businessZones = businessZones;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    public Integer getAdWord() {
        return adWord;
    }

    public void setAdWord(Integer adWord) {
        this.adWord = adWord;
    }

    public String getFormatCreateTime() {
        return formatCreateTime;
    }

    public void setFormatCreateTime(String formatCreateTime) {
        this.formatCreateTime = formatCreateTime;
    }

    public String getImState() {
        return imState;
    }

    public void setImState(String imState) {
        this.imState = imState;
    }

    public Long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }

    public Integer getPcShow() {
        return pcShow;
    }

    public void setPcShow(Integer pcShow) {
        this.pcShow = pcShow;
    }

    public Integer getAppShow() {
        return appShow;
    }

    public void setAppShow(Integer appShow) {
        this.appShow = appShow;
    }

    public Integer getDeliver() {
        return deliver;
    }

    public void setDeliver(Integer deliver) {
        this.deliver = deliver;
    }

    public String getGradeDescription() {
        return gradeDescription;
    }

    public void setGradeDescription(String gradeDescription) {
        this.gradeDescription = gradeDescription;
    }

    public String getPromotionScoreExplain() {
        return promotionScoreExplain;
    }

    public void setPromotionScoreExplain(String promotionScoreExplain) {
        this.promotionScoreExplain = promotionScoreExplain;
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

    public Integer getIsSchoolJob() {
        return isSchoolJob;
    }

    public void setIsSchoolJob(Integer isSchoolJob) {
        this.isSchoolJob = isSchoolJob;
    }

    public String getSubwayline() {
        return subwayline;
    }

    public void setSubwayline(String subwayline) {
        this.subwayline = subwayline;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }

    public String getLinestaion() {
        return linestaion;
    }

    public void setLinestaion(String linestaion) {
        this.linestaion = linestaion;
    }

    public Integer getProcessed() {
        return processed;
    }

    public void setProcessed(Integer processed) {
        this.processed = processed;
    }

    @Override
    public Serializable getId() {
        return positionId;
    }

    @Override
    public boolean equals(Object target) {
        return BeanUtils.equals(this, target);
    }
}
