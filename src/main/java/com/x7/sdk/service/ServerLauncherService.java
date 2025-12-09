package com.x7.sdk.service;

import com.x7.sdk.model.request.GetServerLauncherNotifyEncryptionRequest;
import com.x7.sdk.model.request.GetServerLauncherQueryEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;

public interface ServerLauncherService {

    /**
     * 开服查询请求参数加密
     */
    MethodCommonReqResponse encryptServerLauncherQueryRequest(GetServerLauncherQueryEncryptionRequest request);

    /**
     * 开服查询结果验签
     */
    SignatureVerifyCommonResponse decryptServerLauncherQueryResponse(MethodCommonRespVerifyRequestBO request);

    /**
     * 开服通知请求参数加密
     */
    MethodCommonReqResponse encryptServerLauncherNotifyRequest(GetServerLauncherNotifyEncryptionRequest request);

    /**
     * 开服通知结果验签
     */
    SignatureVerifyCommonResponse decryptServerLauncherNotifyResponse(MethodCommonRespVerifyRequestBO request);
}
