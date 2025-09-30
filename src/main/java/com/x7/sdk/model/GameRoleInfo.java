package com.x7.sdk.model;

import java.util.Objects;

public class GameRoleInfo {
    /**
     * 游戏角色ID - 必填，保证唯一性
     */
    private String roleId;

    /**
     * 小7小号ID - 必填
     */
    private String guid;

    /**
     * 角色名称 - 必填
     */
    private String roleName;

    /**
     * 角色所属区服ID - 必填
     */
    private String serverId;

    /**
     * 角色所属区服名称 - 必填
     */
    private String serverName;

    /**
     * 角色等级 - 可选
     */
    private String roleLevel;

    /**
     * 角色战力 - 可选
     */
    private String roleCE;

    /**
     * 角色自定义数据（JSON格式）- 可选
     */
    private String roleStage;

    /**
     * 角色总充值金额 - 可选
     */
    private Double roleRechargeAmount;

    /**
     * 角色所属公会 - 可选
     */
    private String roleGuild;


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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getRoleCE() {
        return roleCE;
    }

    public void setRoleCE(String roleCE) {
        this.roleCE = roleCE;
    }

    public String getRoleStage() {
        return roleStage;
    }

    public void setRoleStage(String roleStage) {
        this.roleStage = roleStage;
    }

    public Double getRoleRechargeAmount() {
        return roleRechargeAmount;
    }

    public void setRoleRechargeAmount(Double roleRechargeAmount) {
        this.roleRechargeAmount = roleRechargeAmount;
    }

    public String getRoleGuild() {
        return roleGuild;
    }

    public void setRoleGuild(String roleGuild) {
        this.roleGuild = roleGuild;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GameRoleInfo)) {
            return false;
        }
        GameRoleInfo that = (GameRoleInfo) o;
        return Objects.equals(roleId, that.roleId) && Objects.equals(guid, that.guid)
                && Objects.equals(roleName, that.roleName) && Objects.equals(serverId, that.serverId)
                && Objects.equals(serverName, that.serverName) && Objects.equals(roleLevel,
                that.roleLevel) && Objects.equals(roleCE, that.roleCE) && Objects.equals(roleStage,
                that.roleStage) && Objects.equals(roleRechargeAmount, that.roleRechargeAmount)
                && Objects.equals(roleGuild, that.roleGuild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, guid, roleName, serverId, serverName, roleLevel, roleCE, roleStage,
                roleRechargeAmount,
                roleGuild);
    }

    @Override
    public String toString() {
        return "GameRoleInfo{" +
                "roleId='" + roleId + '\'' +
                ", guid='" + guid + '\'' +
                ", roleName='" + roleName + '\'' +
                ", serverId='" + serverId + '\'' +
                ", serverName='" + serverName + '\'' +
                ", roleLevel='" + roleLevel + '\'' +
                ", roleCE='" + roleCE + '\'' +
                ", roleStage='" + roleStage + '\'' +
                ", roleRechargeAmount=" + roleRechargeAmount +
                ", roleGuild='" + roleGuild + '\'' +
                '}';
    }
}
