package com.x7.sdk.model.request;

import com.x7.sdk.model.base.EncryptionBaseRequest;
import java.util.Objects;

public class GetInfoDetectionEncryptionRequest extends EncryptionBaseRequest {

    /**
     * 角色所属小号ID
     */
    private String guid;

    /**
     * 检测信息
     */
    private String detectionMessage;


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDetectionMessage() {
        return detectionMessage;
    }

    public void setDetectionMessage(String detectionMessage) {
        this.detectionMessage = detectionMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetInfoDetectionEncryptionRequest)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        GetInfoDetectionEncryptionRequest that = (GetInfoDetectionEncryptionRequest) o;
        return Objects.equals(guid, that.guid) && Objects.equals(detectionMessage,
                that.detectionMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), guid, detectionMessage);
    }

    @Override
    public String toString() {
        return "GetInfoDetectionEncryptionRequest{" +
                "guid='" + guid + '\'' +
                ", detectionMessage='" + detectionMessage + '\'' +
                '}';
    }
}
