package com.x7.sdk.model.response;

import java.util.Objects;

public class MethodCommonReqResponse {
    private String bizParams;
    private String apiMethod;
    private String ReqTime;
    private String appKey;
    private String gameType;
    private String signature;
    private String osType;

    public MethodCommonReqResponse() {
    }

    public MethodCommonReqResponse(String bizParams, String apiMethod, String reqTime, String appKey, String gameType,
            String signature, String osType) {
        this.bizParams = bizParams;
        this.apiMethod = apiMethod;
        ReqTime = reqTime;
        this.appKey = appKey;
        this.gameType = gameType;
        this.signature = signature;
        this.osType = osType;
    }

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
        return ReqTime;
    }

    public void setReqTime(String reqTime) {
        ReqTime = reqTime;
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
        if (!(o instanceof MethodCommonReqResponse)) {
            return false;
        }
        MethodCommonReqResponse that = (MethodCommonReqResponse) o;
        return Objects.equals(bizParams, that.bizParams) && Objects.equals(apiMethod, that.apiMethod)
                && Objects.equals(ReqTime, that.ReqTime) && Objects.equals(appKey, that.appKey)
                && Objects.equals(gameType, that.gameType) && Objects.equals(signature, that.signature)
                && Objects.equals(osType, that.osType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bizParams, apiMethod, ReqTime, appKey, gameType, signature, osType);
    }

    @Override
    public String toString() {
        return "MethodCommonReqResponseBO{" +
                "bizParams='" + bizParams + '\'' +
                ", apiMethod='" + apiMethod + '\'' +
                ", ReqTime='" + ReqTime + '\'' +
                ", appKey='" + appKey + '\'' +
                ", gameType='" + gameType + '\'' +
                ", signature='" + signature + '\'' +
                ", osType='" + osType + '\'' +
                '}';
    }
}
