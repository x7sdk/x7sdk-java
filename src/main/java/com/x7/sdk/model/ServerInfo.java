package com.x7.sdk.model;

import java.util.Objects;

public class ServerInfo {

    /**
     * 区服ID（区服编号）
     */
    private String serverId;

    /**
     * 开服时间，格式使用ISO8601规范，示例：2022-05-20T22:22:22+0800
     */
    private String serverTime;

    /**
     * 区服名称，可为空
     */
    private String serverName;

    /**
     * api区服，如不为空，角色信息查询等接口会优先使用此值作为serverId进行调用查询
     */
    private String apiServer;

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getApiServer() {
        return apiServer;
    }

    public void setApiServer(String apiServer) {
        this.apiServer = apiServer;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ServerInfo)) {
            return false;
        }
        ServerInfo that = (ServerInfo) o;
        return Objects.equals(serverId, that.serverId) && Objects.equals(serverTime, that.serverTime)
                && Objects.equals(serverName, that.serverName) && Objects.equals(apiServer,
                that.apiServer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverId, serverTime, serverName, apiServer);
    }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "serverId='" + serverId + '\'' +
                ", serverTime='" + serverTime + '\'' +
                ", serverName='" + serverName + '\'' +
                ", apiServer='" + apiServer + '\'' +
                '}';
    }
}
