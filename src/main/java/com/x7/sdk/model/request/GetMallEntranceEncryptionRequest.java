package com.x7.sdk.model.request;

import com.x7.sdk.model.GameRoleInfo;
import java.util.Objects;

public class GetMallEntranceEncryptionRequest {
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
     * 游戏角色信息 - 必填
     */
    GameRoleInfo role;

    public GetMallEntranceEncryptionRequest() {
    }

    public GetMallEntranceEncryptionRequest(String reqTime, String appKey, String gameType, String osType,
            GameRoleInfo role) {
        this.reqTime = reqTime;
        this.appKey = appKey;
        this.gameType = gameType;
        this.osType = osType;
        this.role = role;
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

    public GameRoleInfo getRole() {
        return role;
    }

    public void setRole(GameRoleInfo role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetMallEntranceEncryptionRequest)) {
            return false;
        }
        GetMallEntranceEncryptionRequest that = (GetMallEntranceEncryptionRequest) o;
        return Objects.equals(reqTime, that.reqTime) && Objects.equals(appKey, that.appKey)
                && Objects.equals(gameType, that.gameType) && Objects.equals(osType, that.osType)
                && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reqTime, appKey, gameType, osType, role);
    }

    @Override
    public String toString() {
        return "GetMallEntranceEncryptionRequest{" +
                "reqTime='" + reqTime + '\'' +
                ", appKey='" + appKey + '\'' +
                ", gameType='" + gameType + '\'' +
                ", osType='" + osType + '\'' +
                ", role=" + role +
                '}';
    }
}
