package com.x7.sdk.model.base;

import java.util.Objects;

public class EncryptionBaseRequest {
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EncryptionBaseRequest)) {
            return false;
        }
        EncryptionBaseRequest that = (EncryptionBaseRequest) o;
        return Objects.equals(reqTime, that.reqTime) && Objects.equals(appKey, that.appKey)
                && Objects.equals(gameType, that.gameType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reqTime, appKey, gameType);
    }

    @Override
    public String toString() {
        return "EncryptionBaseRequest{" +
                "reqTime='" + reqTime + '\'' +
                ", appKey='" + appKey + '\'' +
                ", gameType='" + gameType + '\'' +
                '}';
    }
}
