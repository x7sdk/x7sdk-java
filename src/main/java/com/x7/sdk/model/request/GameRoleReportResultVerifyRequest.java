package com.x7.sdk.model.request;

import java.util.Objects;

public class GameRoleReportResultVerifyRequest {
    /**
     * 响应参数，值为每个接口对应响应参数的JSON字符串 - 必填
     */
    private String bizResp;

    /**
     * 请求时间，ISO8601格式 - 必填
     */
    private String reqTime;

    /**
     * 游戏appKey - 必填
     */
    private String appKey;

    /**
     * 游戏端类型，网游为client，H5游戏为h5 - 必填
     */
    private String gameType;

    /**
     * 接口名称 - 必填
     */
    private String apiMethod;


    /**
     * 响应签名 - 必填
     */
    private String signature;


    public String getBizResp() {
        return bizResp;
    }

    public void setBizResp(String bizResp) {
        this.bizResp = bizResp;
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

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GameRoleReportResultVerifyRequest)) {
            return false;
        }
        GameRoleReportResultVerifyRequest that = (GameRoleReportResultVerifyRequest) o;
        return Objects.equals(bizResp, that.bizResp) && Objects.equals(reqTime, that.reqTime)
                && Objects.equals(appKey, that.appKey) && Objects.equals(gameType, that.gameType)
                && Objects.equals(apiMethod, that.apiMethod) && Objects.equals(signature,
                that.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bizResp, reqTime, appKey, gameType, apiMethod, signature);
    }

    @Override
    public String toString() {
        return "GameRoleReportResultVerifyRequest{" +
                "bizResp='" + bizResp + '\'' +
                ", reqTime='" + reqTime + '\'' +
                ", appKey='" + appKey + '\'' +
                ", gameType='" + gameType + '\'' +
                ", apiMethod='" + apiMethod + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
