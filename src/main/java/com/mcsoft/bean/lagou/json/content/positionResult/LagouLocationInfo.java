package com.mcsoft.bean.lagou.json.content.positionResult;

/**
 * 拉勾网Ajax请求响应JSON中positionResult对应实体类
 * Created by Mc on 2017/12/8.
 */
public class LagouLocationInfo {
    private String businessZone;
    private boolean queryByGisCode;
    private String locationCode;
    private boolean isAllhotBusinessZone;
    private String city;
    private String district;

    public String getBusinessZone() {
        return businessZone;
    }

    public void setBusinessZone(String businessZone) {
        this.businessZone = businessZone;
    }

    public boolean isQueryByGisCode() {
        return queryByGisCode;
    }

    public void setQueryByGisCode(boolean queryByGisCode) {
        this.queryByGisCode = queryByGisCode;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public boolean isAllhotBusinessZone() {
        return isAllhotBusinessZone;
    }

    public void setAllhotBusinessZone(boolean allhotBusinessZone) {
        isAllhotBusinessZone = allhotBusinessZone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
