package com.x7.sdk.model.request;

import com.x7.sdk.model.base.EncryptionBaseRequest;
import java.util.Objects;

public class GetHandleMethodReportEncryptionRequest extends EncryptionBaseRequest {

    /**
     * 检查结果的ID
     */
    private String detectionLogId;

    /**
     * 操作类型(对检测结果的处理类型【1：拦截发送(禁止该消息发送并提示发送文本中含有敏感信息); 2：不展示(允许发送但实际上会拦截不展示); 3、屏蔽关键词(屏蔽敏感词后剩余内容允许发送); 4、其他】)
     */
    private String operateType;


    public String getDetectionLogId() {
        return detectionLogId;
    }

    public void setDetectionLogId(String detectionLogId) {
        this.detectionLogId = detectionLogId;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetHandleMethodReportEncryptionRequest)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        GetHandleMethodReportEncryptionRequest that = (GetHandleMethodReportEncryptionRequest) o;
        return Objects.equals(detectionLogId, that.detectionLogId) && Objects.equals(operateType,
                that.operateType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), detectionLogId, operateType);
    }

    @Override
    public String toString() {
        return "GetHandleMethodReportEncryptionRequest{" +
                "detectionLogId='" + detectionLogId + '\'' +
                ", operateType='" + operateType + '\'' +
                '}';
    }
}
