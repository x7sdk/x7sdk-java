package com.x7.sdk.model.request;

import com.x7.sdk.model.GameRoleInfo;
import java.util.Objects;

public class GetMallRoleEncryptionRequest {
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


    private String roleId;

    private String guid;

    public GetMallRoleEncryptionRequest() {
    }

    public GetMallRoleEncryptionRequest(String reqTime, String appKey, String gameType, String osType, String roleId,
            String guid) {
        this.reqTime = reqTime;
        this.appKey = appKey;
        this.gameType = gameType;
        this.osType = osType;
        this.roleId = roleId;
        this.guid = guid;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetMallRoleEncryptionRequest)) {
            return false;
        }
        GetMallRoleEncryptionRequest that = (GetMallRoleEncryptionRequest) o;
        return Objects.equals(reqTime, that.reqTime) && Objects.equals(appKey, that.appKey)
                && Objects.equals(gameType, that.gameType) && Objects.equals(osType, that.osType)
                && Objects.equals(roleId, that.roleId) && Objects.equals(guid, that.guid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reqTime, appKey, gameType, osType, roleId, guid);
    }

    @Override
    public String toString() {
        return "GetMallRoleEncryptionRequest{" +
                "reqTime='" + reqTime + '\'' +
                ", appKey='" + appKey + '\'' +
                ", gameType='" + gameType + '\'' +
                ", osType='" + osType + '\'' +
                ", roleId='" + roleId + '\'' +
                ", guid='" + guid + '\'' +
                '}';
    }
}
