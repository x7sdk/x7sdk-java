package com.x7.sdk.service;

import com.x7.sdk.model.request.GetHandleMethodReportEncryptionRequest;
import com.x7.sdk.model.request.GetInfoDetectionEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;

public interface SensitiveWordDetectionService {

    /**
     * 信息检测接口请求参数加密
     * @param plainText 明文检测参数
     * @return 加密后的检测参数
     */
    MethodCommonReqResponse encryptDetectionRequest(GetInfoDetectionEncryptionRequest request);

    /**
     * 检测结果解密
     * @param encryptedResult 加密的检测结果
     * @return 解密后的检测结果
     */
    SignatureVerifyCommonResponse decryptDetectionResult(MethodCommonRespVerifyRequestBO request);

    /**
     * 处理方式上报接口请求参数加密
     * @param reportData 上报数据对象
     * @return 加密后的上报参数
     */
    MethodCommonReqResponse encryptReportRequest(GetHandleMethodReportEncryptionRequest request);

    /**
     * 处理方式上报接口返回结果解密
     * @param encryptedResponse 加密的上报响应
     * @return 解密后的上报响应结果
     */
    SignatureVerifyCommonResponse decryptReportResponse(MethodCommonRespVerifyRequestBO encryptedResponse);

}
