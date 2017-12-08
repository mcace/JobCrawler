package com.mcsoft.bean.lagou.json.content.positionResult;

/**
 * 拉勾网Ajax请求响应JSON中queryAnalysisInfo对应实体类
 * Created by Mc on 2017/12/8.
 */
public class LagouQueryAnalysisInfo {
    private String industryName;
    private boolean usefulCompany;
    private String positionName;
    private String companyName;

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public boolean isUsefulCompany() {
        return usefulCompany;
    }

    public void setUsefulCompany(boolean usefulCompany) {
        this.usefulCompany = usefulCompany;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
