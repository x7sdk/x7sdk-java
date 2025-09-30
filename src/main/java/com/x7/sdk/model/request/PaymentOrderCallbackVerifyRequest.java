package com.x7.sdk.model.request;

import java.util.Objects;

public class PaymentOrderCallbackVerifyRequest {

    /**
     * RSA加密的关键数据
     */
    private String encrypData;

    /**
     * 支付透传参数
     */
    private String extendsInfoData;

    /**
     * 游戏所在区服
     */
    private String gameArea;

    /**
     * 用户游戏角色等级
     */
    private String gameLevel;

    /**
     * 游戏订单号
     */
    private String gameOrderId;

    /**
     * 游戏角色信息ID
     */
    private String gameRoleId;

    /**
     * 游戏角色名称
     */
    private String gameRoleName;

    /**
     * SDK版本号
     */
    private String sdkVersion;

    /**
     * 游戏商品简介
     */
    private String subject;

    /**
     * 小7服务器订单ID
     */
    private Integer xiao7Goid;

    /**
     * 代金券金额
     */
    private Double couponPrice;

    /**
     * RSA签名数据
     */
    private String signData;

    // Getter 和 Setter 方法
    public String getEncrypData() {
        return encrypData;
    }

    public void setEncrypData(String encrypData) {
        this.encrypData = encrypData;
    }

    public String getExtendsInfoData() {
        return extendsInfoData;
    }

    public void setExtendsInfoData(String extendsInfoData) {
        this.extendsInfoData = extendsInfoData;
    }

    public String getGameArea() {
        return gameArea;
    }

    public void setGameArea(String gameArea) {
        this.gameArea = gameArea;
    }

    public String getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(String gameLevel) {
        this.gameLevel = gameLevel;
    }

    public String getGameOrderId() {
        return gameOrderId;
    }

    public void setGameOrderId(String gameOrderId) {
        this.gameOrderId = gameOrderId;
    }

    public String getGameRoleId() {
        return gameRoleId;
    }

    public void setGameRoleId(String gameRoleId) {
        this.gameRoleId = gameRoleId;
    }

    public String getGameRoleName() {
        return gameRoleName;
    }

    public void setGameRoleName(String gameRoleName) {
        this.gameRoleName = gameRoleName;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getXiao7Goid() {
        return xiao7Goid;
    }

    public void setXiao7Goid(Integer xiao7Goid) {
        this.xiao7Goid = xiao7Goid;
    }

    public Double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(Double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public String getSignData() {
        return signData;
    }

    public void setSignData(String signData) {
        this.signData = signData;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PaymentOrderCallbackVerifyRequest)) {
            return false;
        }
        PaymentOrderCallbackVerifyRequest that = (PaymentOrderCallbackVerifyRequest) o;
        return Objects.equals(encrypData, that.encrypData) &&
                Objects.equals(extendsInfoData, that.extendsInfoData) &&
                Objects.equals(gameArea, that.gameArea) &&
                Objects.equals(gameLevel, that.gameLevel) &&
                Objects.equals(gameOrderId, that.gameOrderId) &&
                Objects.equals(gameRoleId, that.gameRoleId) &&
                Objects.equals(gameRoleName, that.gameRoleName) &&
                Objects.equals(sdkVersion, that.sdkVersion) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(xiao7Goid, that.xiao7Goid) &&
                Objects.equals(couponPrice, that.couponPrice) &&
                Objects.equals(signData, that.signData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encrypData, extendsInfoData, gameArea, gameLevel, gameOrderId,
                gameRoleId, gameRoleName, sdkVersion, subject, xiao7Goid, couponPrice, signData);
    }

    @Override
    public String toString() {
        return "PaymentOrderCallbackVerifyRequest{" +
                "encrypData='" + encrypData + '\'' +
                ", extendsInfoData='" + extendsInfoData + '\'' +
                ", gameArea='" + gameArea + '\'' +
                ", gameLevel='" + gameLevel + '\'' +
                ", gameOrderId='" + gameOrderId + '\'' +
                ", gameRoleId='" + gameRoleId + '\'' +
                ", gameRoleName='" + gameRoleName + '\'' +
                ", sdkVersion='" + sdkVersion + '\'' +
                ", subject='" + subject + '\'' +
                ", xiao7Goid=" + xiao7Goid +
                ", couponPrice=" + couponPrice +
                ", signData='" + signData + '\'' +
                '}';
    }
}