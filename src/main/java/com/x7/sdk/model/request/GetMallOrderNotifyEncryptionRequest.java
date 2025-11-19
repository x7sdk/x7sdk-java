package com.x7.sdk.model.request;

import java.util.Objects;

public class GetMallOrderNotifyEncryptionRequest {
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
     * 订单号 - 必填
     */
    private String orderId;

    /**
     * 小7订单ID - 必填
     */
    private String x7Gold;

    /**
     * 小号ID - 必填
     */
    private String guid;

    /**
     * 角色ID - 必填
     */
    private String roleId;

    /**
     * 角色名称 - 必填
     */
    private String roleName;

    /**
     * 角色所属区服ID - 必填
     */
    private String serverId;

    /**
     * 区服名称 - 必填
     */
    private String serverName;

    /**
     * 商城活动名称 - 必填
     */
    private String activityName;

    /**
     * 订单商品信息 - 必填
     */
    private String subject;

    /**
     * 商品原价，精度为小数点后2位 - 必填
     */
    private String price;

    /**
     * 代金券面值，精度为小数点后2位 - 必填
     */
    private String couponValue;

    /**
     * 订单实际支付金额，精度为小数点后2位 - 必填
     */
    private String payPrice;

    /**
     * 订单创建时间，格式为ISO8601 - 必填
     */
    private String createTime;

    /**
     * 订单成功支付时间，格式为ISO8601 - 必填
     */
    private String successTime;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getX7Gold() {
        return x7Gold;
    }

    public void setX7Gold(String x7Gold) {
        this.x7Gold = x7Gold;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(String couponValue) {
        this.couponValue = couponValue;
    }

    public String getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(String payPrice) {
        this.payPrice = payPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetMallOrderNotifyEncryptionRequest that = (GetMallOrderNotifyEncryptionRequest) o;
        return Objects.equals(reqTime, that.reqTime) &&
                Objects.equals(appKey, that.appKey) &&
                Objects.equals(gameType, that.gameType) &&
                Objects.equals(osType, that.osType) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(x7Gold, that.x7Gold) &&
                Objects.equals(guid, that.guid) &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(serverId, that.serverId) &&
                Objects.equals(serverName, that.serverName) &&
                Objects.equals(activityName, that.activityName) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(price, that.price) &&
                Objects.equals(couponValue, that.couponValue) &&
                Objects.equals(payPrice, that.payPrice) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(successTime, that.successTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reqTime, appKey, gameType, osType, orderId, x7Gold, guid, roleId, roleName, serverId, serverName, activityName, subject, price, couponValue, payPrice, createTime, successTime);
    }

    @Override
    public String toString() {
        return "GetMalOrderNotifyEncryptionRequest{" +
                "reqTime='" + reqTime + '\'' +
                ", appKey='" + appKey + '\'' +
                ", gameType='" + gameType + '\'' +
                ", osType='" + osType + '\'' +
                ", orderId='" + orderId + '\'' +
                ", x7Gold='" + x7Gold + '\'' +
                ", guid='" + guid + '\'' +
                ", roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", serverId='" + serverId + '\'' +
                ", serverName='" + serverName + '\'' +
                ", activityName='" + activityName + '\'' +
                ", subject='" + subject + '\'' +
                ", price='" + price + '\'' +
                ", couponValue='" + couponValue + '\'' +
                ", payPrice='" + payPrice + '\'' +
                ", createTime='" + createTime + '\'' +
                ", successTime='" + successTime + '\'' +
                '}';
    }
}