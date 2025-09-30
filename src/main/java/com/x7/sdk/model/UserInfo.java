package com.x7.sdk.model;

import java.util.Objects;

/**
 * 用户信息实体类 包含从小7平台获取的用户基本信息
 */
public class UserInfo {

    /**
     * 标识用户在小7平台中的唯一标识。
     */
    private String guid;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 是否已经实名，1表示已经实名，-1表示还没有实名。
     */
    private String isRealUser;

    /**
     * 是否满足18岁，1表示已经满18岁，-1表示还没有满18岁。
     */
    private String isEighteen;

    /**
     * 一个会话标识只能对应唯一的实名用户，一个实名用户可以拥有多个会话标识；
     * 同一用户单次游戏会话中，上下线动作必须使用同一会话标识上报。
     * 备注：会话标识仅标识一次用户会话，生命周期仅为一次上线和与之匹配的一次下线，不会对生命周期之外的任何业务有任何影响。
     */
    private String si;

    /**
     * 已通过实名认证用户的唯一标识，已认证通过用户必填。
     */
    private String pi;

    /**
     * 游客模式设备标识，由游戏运营单位生成，游客用户下必填。
     */
    private String di;


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIsRealUser() {
        return isRealUser;
    }

    public void setIsRealUser(String isRealUser) {
        this.isRealUser = isRealUser;
    }

    public String getIsEighteen() {
        return isEighteen;
    }

    public void setIsEighteen(String isEighteen) {
        this.isEighteen = isEighteen;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getDi() {
        return di;
    }

    public void setDi(String di) {
        this.di = di;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(guid, userInfo.guid) && Objects.equals(username, userInfo.username)
                && Objects.equals(isRealUser, userInfo.isRealUser) && Objects.equals(isEighteen,
                userInfo.isEighteen) && Objects.equals(si, userInfo.si) && Objects.equals(pi,
                userInfo.pi) && Objects.equals(di, userInfo.di);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, username, isRealUser, isEighteen, si, pi, di);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "guid='" + guid + '\'' +
                ", username='" + username + '\'' +
                ", isRealUser='" + isRealUser + '\'' +
                ", isEighteen='" + isEighteen + '\'' +
                ", si='" + si + '\'' +
                ", pi='" + pi + '\'' +
                ", di='" + di + '\'' +
                '}';
    }
}
