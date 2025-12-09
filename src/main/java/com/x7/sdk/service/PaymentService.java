package com.x7.sdk.service;

import com.x7.sdk.model.request.PaymentOrderCallbackVerifyRequest;
import com.x7.sdk.model.request.PaymentOrderEncryptedRequest;
import com.x7.sdk.model.response.PaymentOrderCallbackVerifyResponse;
import com.x7.sdk.model.response.PaymentOrderEncryptedResponse;

public interface PaymentService {

    /**
     * 获取支付订单加密信息
     * @param request
     * @return
     */
    PaymentOrderEncryptedResponse getPaymentOrderEncrypted(PaymentOrderEncryptedRequest request);

    /**
     * 订单回调验证签名
     */
    PaymentOrderCallbackVerifyResponse getPaymentOrderCallbackVerify(PaymentOrderCallbackVerifyRequest request);
}
