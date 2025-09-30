package com.x7.sdk.model;

import java.util.Objects;

public class UserRealNameInfo {

    /**
     * 条目编码 - 在批量模式中标识一条行为数据，取值范围1-128
     */
    private Integer no;

    /**
     * 游戏内部会话标识 - 32位字符串
     * 一个会话标识只能对应唯一的实名用户，一个实名用户可以拥有多个会话标识
     * 同一用户单次游戏会话中，上下线动作必须使用同一会话标识上报
     */
    private String si;

    /**
     * 用户行为类型 - 游戏用户行为类型【0：下线；1：上线】
     */
    private Integer bt;

    /**
     * 行为发生时间 - 行为发生时间戳，单位秒
     */
    private Long ot;

    /**
     * 上报类型 - 用户行为数据上报类型【0：已认证通过用户；2：游客用户】
     */
    private Integer ct;

    /**
     * 设备标识 - 游客模式设备标识，由游戏运营单位生成，游客用户下必填
     */
    private String di;

    /**
     * 用户唯一标识 - 已通过实名认证用户的唯一标识，已认证通过用户必填
     */
    private String pi;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public Integer getBt() {
        return bt;
    }

    public void setBt(Integer bt) {
        this.bt = bt;
    }

    public Long getOt() {
        return ot;
    }

    public void setOt(Long ot) {
        this.ot = ot;
    }

    public Integer getCt() {
        return ct;
    }

    public void setCt(Integer ct) {
        this.ct = ct;
    }

    public String getDi() {
        return di;
    }

    public void setDi(String di) {
        this.di = di;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserRealNameInfo)) {
            return false;
        }
        UserRealNameInfo that = (UserRealNameInfo) o;
        return Objects.equals(no, that.no) && Objects.equals(si, that.si) && Objects.equals(
                bt, that.bt) && Objects.equals(ot, that.ot) && Objects.equals(ct, that.ct)
                && Objects.equals(di, that.di) && Objects.equals(pi, that.pi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, si, bt, ot, ct, di, pi);
    }

    @Override
    public String toString() {
        return "UserRealNameInfo{" +
                "no=" + no +
                ", si='" + si + '\'' +
                ", bt=" + bt +
                ", ot=" + ot +
                ", ct=" + ct +
                ", di='" + di + '\'' +
                ", pi='" + pi + '\'' +
                '}';
    }
}
