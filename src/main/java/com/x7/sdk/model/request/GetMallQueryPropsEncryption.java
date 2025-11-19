package com.x7.sdk.model.request;

import com.x7.sdk.model.IssuedProp;
import java.util.List;
import java.util.Objects;

public class GetMallQueryPropsEncryption {
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


    private String osType;

    /**
     * 道具编码列表 - 必填
     */
    private List<String> propCode;

    public GetMallQueryPropsEncryption() {
    }

    public GetMallQueryPropsEncryption(String reqTime, String appKey, String gameType, String osType,
            List<String> propCode) {
        this.reqTime = reqTime;
        this.appKey = appKey;
        this.gameType = gameType;
        this.osType = osType;
        this.propCode = propCode;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetMallQueryPropsEncryption)) {
            return false;
        }
        GetMallQueryPropsEncryption that = (GetMallQueryPropsEncryption) o;
        return Objects.equals(reqTime, that.reqTime) && Objects.equals(appKey, that.appKey)
                && Objects.equals(gameType, that.gameType) && Objects.equals(osType, that.osType)
                && Objects.equals(propCode, that.propCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reqTime, appKey, gameType, osType, propCode);
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

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public List<String> getPropCode() {
        return propCode;
    }

    public void setPropCode(List<String> propCode) {
        this.propCode = propCode;
    }

    @Override
    public String toString() {
        return "GetMallQueryPropsEncryption{" +
                "reqTime='" + reqTime + '\'' +
                ", appKey='" + appKey + '\'' +
                ", gameType='" + gameType + '\'' +
                ", osType='" + osType + '\'' +
                ", propCode=" + propCode +
                '}';
    }
}
