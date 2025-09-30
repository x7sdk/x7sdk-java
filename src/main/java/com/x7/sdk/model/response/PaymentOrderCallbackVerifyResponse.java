package com.x7.sdk.model.response;

import com.x7.sdk.model.PaymentOrderInfo;
import java.util.Objects;

public class PaymentOrderCallbackVerifyResponse {

    /**
     * 是否验签成功
     */
    private Boolean isValid;

    /**
     * 支付订单信息
     */
    private PaymentOrderInfo paymentOrderInfo;

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public PaymentOrderInfo getPaymentOrderInfo() {
        return paymentOrderInfo;
    }

    public void setPaymentOrderInfo(PaymentOrderInfo paymentOrderInfo) {
        this.paymentOrderInfo = paymentOrderInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PaymentOrderCallbackVerifyResponse)) {
            return false;
        }
        PaymentOrderCallbackVerifyResponse that = (PaymentOrderCallbackVerifyResponse) o;
        return Objects.equals(isValid, that.isValid) && Objects.equals(paymentOrderInfo,
                that.paymentOrderInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isValid, paymentOrderInfo);
    }

    @Override
    public String toString() {
        return "PaymentOrderCallbackVerifyResponse{" +
                "isValid=" + isValid +
                ", paymentOrderInfo=" + paymentOrderInfo +
                '}';
    }
}
