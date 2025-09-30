package com.x7.sdk.model.request;

import com.x7.sdk.model.GameRoleInfo;
import java.util.Objects;

public class GetGameRoleReportSignRequest {

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
     * 游戏角色信息 - 必填
     */
    GameRoleInfo role;


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

    public GameRoleInfo getRole() {
        return role;
    }

    public void setRole(GameRoleInfo role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetGameRoleReportSignRequest)) {
            return false;
        }
        GetGameRoleReportSignRequest that = (GetGameRoleReportSignRequest) o;
        return  Objects.equals(reqTime, that.reqTime)
                && Objects.equals(appKey, that.appKey) && Objects.equals(gameType, that.gameType)
                && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reqTime, appKey, gameType, role);
    }

    @Override
    public String toString() {
        return "GetGameRoleReportSignRequest{" +
                ", reqTime='" + reqTime + '\'' +
                ", appKey='" + appKey + '\'' +
                ", gameType='" + gameType + '\'' +
                ", role=" + role +
                '}';
    }
}
