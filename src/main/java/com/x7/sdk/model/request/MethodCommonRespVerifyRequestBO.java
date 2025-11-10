package com.x7.sdk.model.request;

import java.util.Objects;

public class MethodCommonRespVerifyRequestBO {
    /**
     * 响应参数，JSON字符串 - 必填
     */
    private String bizResp;

    /**
     * 接口名称 - 必填
     */
    private String apiMethod;

    /**
     * 响应时间，ISO8601格式，示例：2022-05-20T05:20:20+0800 - 必填
     */
    private String respTime;

    /**
     * 游戏appkey - 必填
     */
    private String appkey;

    /**
     * 游戏端类型，网游为client，H5游戏为h5 - 必填
     */
    private String gameType;

    /**
     * 响应签名 - 必填
     */
    private String signature;

    /**
     * 系统类型，ios 或 android - 非必填
     */
    private String osType;

    public String getBizResp() {
        return bizResp;
    }

    public void setBizResp(String bizResp) {
        this.bizResp = bizResp;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getRespTime() {
        return respTime;
    }

    public void setRespTime(String respTime) {
        this.respTime = respTime;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodCommonRespVerifyRequestBO that = (MethodCommonRespVerifyRequestBO) o;
        return Objects.equals(bizResp, that.bizResp) &&
                Objects.equals(apiMethod, that.apiMethod) &&
                Objects.equals(respTime, that.respTime) &&
                Objects.equals(appkey, that.appkey) &&
                Objects.equals(gameType, that.gameType) &&
                Objects.equals(signature, that.signature) &&
                Objects.equals(osType, that.osType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bizResp, apiMethod, respTime, appkey, gameType, signature, osType);
    }

    @Override
    public String toString() {
        return "MethodCommonRespVerifyRequestBO{" +
                "bizResp='" + bizResp + '\'' +
                ", apiMethod='" + apiMethod + '\'' +
                ", respTime='" + respTime + '\'' +
                ", appkey='" + appkey + '\'' +
                ", gameType='" + gameType + '\'' +
                ", signature='" + signature + '\'' +
                ", osType='" + osType + '\'' +
                '}';
    }
}
