package com.x7.sdk.model.request;

import com.x7.sdk.model.base.EncryptionBaseRequest;
import java.util.List;
import java.util.Objects;

public class GetIpWhiteEncryptionRequest extends EncryptionBaseRequest {

    /**
     * ip白名单类型，支持类型：client
     */
    private String ipType;

    private List<String> ipList;

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

    public String getIpType() {
        return ipType;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetIpWhiteEncryptionRequest)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        GetIpWhiteEncryptionRequest that = (GetIpWhiteEncryptionRequest) o;
        return Objects.equals(ipType, that.ipType) && Objects.equals(ipList, that.ipList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ipType, ipList);
    }

    @Override
    public String toString() {
        return "GetIpWhiteEncryptionRequest{" +
                "ipType='" + ipType + '\'' +
                ", ipList=" + ipList +
                '}';
    }
}
