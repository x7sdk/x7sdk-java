package com.x7.sdk.service;

import com.x7.sdk.model.request.PaymentOrderCallbackVerifyRequest;
import com.x7.sdk.model.request.PaymentOrderEncryptedRequest;
import com.x7.sdk.model.response.PaymentOrderCallbackVerifyResponse;
import com.x7.sdk.model.response.PaymentOrderEncryptedResponse;

public interface PaymentService {

    PaymentOrderEncryptedResponse getPaymentOrderEncrypted(PaymentOrderEncryptedRequest request);

    PaymentOrderCallbackVerifyResponse getPaymentOrderCallbackVerify(PaymentOrderCallbackVerifyRequest request);
}
