package com.x7.sdk.model.response;

import java.util.Objects;

public class PaymentOrderEncryptedResponse {

    /**
     * 订单扩展数据（选填） 支持json格式，可用于传递道具ID等信息，用于回调时逻辑校验 长度：128字符
     */
    private String extendsInfoData;

    /**
     * 角色所在的游戏区服名称（必填） 对应服务端角色信息变更的role.serverName字段 注意：正确填写有助于充值问题快速排查 长度：20字符
     */
    private String gameArea;

    /**
     * 角色等级（必填） 对应服务端角色信息变更的role.roleLevel字段 长度：30字符
     */
    private String gameLevel;

    /**
     * 游戏方生成的订单号（必填） 长度：100字符
     */
    private String gameOrderId;

    /**
     * 商品价格货币单位（必填） 可用值：CNY-人民币, USD-美元, HKD-港币, VND-越南盾, KRW-韩元, THB-泰铢 长度：10字符
     */
    private String gameCurrency;

    /**
     * 商品价格（必填） 需保留小数点后两位，示例：100.00 长度：10,2（整数部分10位，小数部分2位）
     */
    private String gamePrice;

    /**
     * 角色ID（必填） 确保角色id在游戏内是唯一的，如果角色id会重复，可通过拼接其他参数等方式实现唯一性 长度：30字符
     */
    private String gameRoleId;

    /**
     * 角色名称（必填） 长度：30字符
     */
    private String gameRoleName;

    /**
     * 用户游戏小号的唯一标识（必填） 登录成功后调用小7验证用户信息接口获取 长度：12位数字
     */
    private Integer gameGuid;

    /**
     * 支付回调通知ID（必填） 如果只有一个支付回调地址可以设置成-1，在小7开发者平台可以查看 长度：11字符
     */
    private String notifyId;

    /**
     * 道具简介（必填） 长度：100字符
     */
    private String subject;

    /**
     * 接入签名方式版本（必填） 新游戏接入选择最新版2587即可 长度：10字符
     */
    private String gameAccessVersion;

    /**
     * 签名。将其他所有字段按字典序生成QueryString，得到QueryString后，在后面拼接小7RSA公钥，最后再将拼接好的字符串进行MD5即可得到签名字符串
     */
    private String gameSign;

    public String getGameSign() {
        return gameSign;
    }

    public void setGameSign(String gameSign) {
        this.gameSign = gameSign;
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

    public String getGameCurrency() {
        return gameCurrency;
    }

    public void setGameCurrency(String gameCurrency) {
        this.gameCurrency = gameCurrency;
    }

    public String getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(String gamePrice) {
        this.gamePrice = gamePrice;
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

    public Integer getGameGuid() {
        return gameGuid;
    }

    public void setGameGuid(Integer gameGuid) {
        this.gameGuid = gameGuid;
    }

    public String getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGameAccessVersion() {
        return gameAccessVersion;
    }

    public void setGameAccessVersion(String gameAccessVersion) {
        this.gameAccessVersion = gameAccessVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PaymentOrderEncryptedResponse)) {
            return false;
        }
        PaymentOrderEncryptedResponse that = (PaymentOrderEncryptedResponse) o;
        return Objects.equals(extendsInfoData, that.extendsInfoData) && Objects.equals(gameArea,
                that.gameArea) && Objects.equals(gameLevel, that.gameLevel) && Objects.equals(
                gameOrderId, that.gameOrderId) && Objects.equals(gameCurrency, that.gameCurrency)
                && Objects.equals(gamePrice, that.gamePrice) && Objects.equals(gameRoleId,
                that.gameRoleId) && Objects.equals(gameRoleName, that.gameRoleName) && Objects.equals(
                gameGuid, that.gameGuid) && Objects.equals(notifyId, that.notifyId) && Objects.equals(
                subject, that.subject) && Objects.equals(gameAccessVersion, that.gameAccessVersion)
                && Objects.equals(gameSign, that.gameSign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extendsInfoData, gameArea, gameLevel, gameOrderId, gameCurrency, gamePrice, gameRoleId,
                gameRoleName, gameGuid, notifyId, subject, gameAccessVersion, gameSign);
    }

    @Override
    public String toString() {
        return "PaymentOrderEncryptedResponse{" +
                "extendsInfoData='" + extendsInfoData + '\'' +
                ", gameArea='" + gameArea + '\'' +
                ", gameLevel='" + gameLevel + '\'' +
                ", gameOrderId='" + gameOrderId + '\'' +
                ", gameCurrency='" + gameCurrency + '\'' +
                ", gamePrice='" + gamePrice + '\'' +
                ", gameRoleId='" + gameRoleId + '\'' +
                ", gameRoleName='" + gameRoleName + '\'' +
                ", gameGuid=" + gameGuid +
                ", notifyId='" + notifyId + '\'' +
                ", subject='" + subject + '\'' +
                ", gameAccessVersion='" + gameAccessVersion + '\'' +
                ", gameSign='" + gameSign + '\'' +
                '}';
    }
}
