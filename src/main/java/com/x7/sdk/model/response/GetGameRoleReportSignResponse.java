package com.x7.sdk.model.response;

import java.util.Objects;

public class GetGameRoleReportSignResponse {
    private String bizParams;

    /**
     * 接口名称 - 必填，固定为"common.roleReport"
     */
    private String apiMethod;

    /**
     * 请求时间，ISO8601格式 - 必填
     */
    private String reqTime;

    /**
     * 游戏appkey - 必填
     */
    private String appKey;

    /**
     * 游戏端类型，网游为client，H5游戏为h5 - 必填
     */
    private String gameType;

    /**
     * 请求签名 - 必填
     */
    private String signature;

    /**
     * 系统类型，ios或android - 可选
     */
    private String osType;

    public String getBizParams() {
        return bizParams;
    }

    public void setBizParams(String bizParams) {
        this.bizParams = bizParams;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetGameRoleReportSignResponse)) {
            return false;
        }
        GetGameRoleReportSignResponse that = (GetGameRoleReportSignResponse) o;
        return Objects.equals(bizParams, that.bizParams) && Objects.equals(apiMethod, that.apiMethod)
                && Objects.equals(reqTime, that.reqTime) && Objects.equals(appKey, that.appKey)
                && Objects.equals(gameType, that.gameType) && Objects.equals(signature, that.signature)
                && Objects.equals(osType, that.osType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bizParams, apiMethod, reqTime, appKey, gameType, signature, osType);
    }

    @Override
    public String toString() {
        return "GetGameRoleReportSignResponse{" +
                "bizParams='" + bizParams + '\'' +
                ", apiMethod='" + apiMethod + '\'' +
                ", reqTime='" + reqTime + '\'' +
                ", appKey='" + appKey + '\'' +
                ", gameType='" + gameType + '\'' +
                ", signature='" + signature + '\'' +
                ", osType='" + osType + '\'' +
                '}';
    }
}
