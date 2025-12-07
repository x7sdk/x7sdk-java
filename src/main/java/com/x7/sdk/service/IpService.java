package com.x7.sdk.service;

import com.x7.sdk.model.request.GetIpWhiteEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;

public interface IpService {
    /**
     * 获取ip白名单查询接口请求参数加密
     */
    public MethodCommonReqResponse encryptIpWhiteListRequest(GetIpWhiteEncryptionRequest request);

    /**
     * 获取ip白名单查询接口请求参数解密
     */
    public SignatureVerifyCommonResponse decryptIpWhiteListResponse(MethodCommonRespVerifyRequestBO request);

}
