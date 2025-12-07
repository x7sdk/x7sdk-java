package com.x7.sdk.model.request;

import com.x7.sdk.model.base.EncryptionBaseRequest;
import java.util.Objects;

public class GetPaymentOrderQueryEncryptionRequest extends EncryptionBaseRequest {


    /**
     * 开始时间，格式使用ISO8601规范，示例：2022-05-20T22:22:22+0800
     */
    private String startTime;

    /**
     * 结束时间，格式使用ISO8601规范，示例：2022-05-20T22:22:22+0800
     */
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetPaymentOrderQueryEncryptionRequest)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        GetPaymentOrderQueryEncryptionRequest that = (GetPaymentOrderQueryEncryptionRequest) o;
        return Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), startTime, endTime);
    }

    @Override
    public String toString() {
        return "GetPaymentOrderQueryEncryptionRequest{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
