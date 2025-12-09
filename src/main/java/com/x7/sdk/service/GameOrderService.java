package com.x7.sdk.service;

import com.x7.sdk.model.request.GetPaymentOrderQueryEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;

public interface GameOrderService {

    /**
     * 订单查询请求参数加密
     */
    MethodCommonReqResponse encryptPaymentOrderQueryRequest(GetPaymentOrderQueryEncryptionRequest request);

    /**
     * 订单查询结果验签
     */
    SignatureVerifyCommonResponse decryptPaymentOrderQueryResponse(MethodCommonRespVerifyRequestBO request);
}
