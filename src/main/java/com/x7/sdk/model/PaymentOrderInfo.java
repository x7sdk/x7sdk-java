package com.x7.sdk.model;

import java.util.Objects;

public class PaymentOrderInfo {

    /**
     * 游戏订单号
     */

    private String gameOrderId;

    /**
     * 商品原价（精确到小数点后两位）
     */

    private Double payPrice;

    /**
     * 标识用户在小7平台中的唯一标识
     */

    private Integer guid;

    /**
     * 折后付费金额（精确到小数点后两位，仅sdk_version=6.1时有该字段）
     */

    private Double discountedPrice;

    /**
     * 游戏内货币单位（仅sdk_version=7.98时有该字段）
     */
    private String gameCurrency;

    public String getGameOrderId() {
        return gameOrderId;
    }

    public void setGameOrderId(String gameOrderId) {
        this.gameOrderId = gameOrderId;
    }

    public Double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Double payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getGuid() {
        return guid;
    }

    public void setGuid(Integer guid) {
        this.guid = guid;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getGameCurrency() {
        return gameCurrency;
    }

    public void setGameCurrency(String gameCurrency) {
        this.gameCurrency = gameCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PaymentOrderInfo)) {
            return false;
        }
        PaymentOrderInfo that = (PaymentOrderInfo) o;
        return Objects.equals(gameOrderId, that.gameOrderId) && Objects.equals(payPrice, that.payPrice)
                && Objects.equals(guid, that.guid) && Objects.equals(discountedPrice,
                that.discountedPrice) && Objects.equals(gameCurrency, that.gameCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameOrderId, payPrice, guid, discountedPrice, gameCurrency);
    }

    @Override
    public String toString() {
        return "PaymentOrderInfo{" +
                "gameOrderId='" + gameOrderId + '\'' +
                ", payPrice=" + payPrice +
                ", guid=" + guid +
                ", discountedPrice=" + discountedPrice +
                ", gameCurrency='" + gameCurrency + '\'' +
                '}';
    }
}
