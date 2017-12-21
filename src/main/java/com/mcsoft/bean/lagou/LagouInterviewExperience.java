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
 * 拉勾网面试反馈实体类
 * Created by Mc on 2017/12/20.
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "lagou_interview_experience")
public class LagouInterviewExperience implements DBModel{
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "companyId")
    private int companyId;
    @Column(name = "positionId")
    private int positionId;
    @Column(name = "companyScore")
    private int companyScore;//公司环境
    @Column(name = "describeScore")
    private int describeScore;//描述相符
    @Column(name = "interviewerScore")
    private int interviewerScore;//面试官
    @Column(name = "comprehensiveScore")
    private int comprehensiveScore;//综合分
    @Column(name = "myScore")
    private int myScore;
    @Column(name = "content")
    private String content;//评价
    @Column(name = "positionName")
    private String positionName;
    @Column(name = "positionType")
    private String positionType;
    @Column(name = "createTime")
    private String createTime;
    @Column(name = "usefulCount")
    private int usefulCount;//[有用]数量
    @Column(name = "tags")
    private String tags;

    @Override
    public Serializable getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getCompanyScore() {
        return companyScore;
    }

    public void setCompanyScore(int companyScore) {
        this.companyScore = companyScore;
    }

    public int getDescribeScore() {
        return describeScore;
    }

    public void setDescribeScore(int describeScore) {
        this.describeScore = describeScore;
    }

    public int getInterviewerScore() {
        return interviewerScore;
    }

    public void setInterviewerScore(int interviewerScore) {
        this.interviewerScore = interviewerScore;
    }

    public int getComprehensiveScore() {
        return comprehensiveScore;
    }

    public void setComprehensiveScore(int comprehensiveScore) {
        this.comprehensiveScore = comprehensiveScore;
    }

    public int getMyScore() {
        return myScore;
    }

    public void setMyScore(int myScore) {
        this.myScore = myScore;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getUsefulCount() {
        return usefulCount;
    }

    public void setUsefulCount(int usefulCount) {
        this.usefulCount = usefulCount;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
