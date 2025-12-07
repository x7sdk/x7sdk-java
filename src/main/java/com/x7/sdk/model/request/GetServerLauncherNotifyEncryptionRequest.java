package com.x7.sdk.model.request;

import com.x7.sdk.model.ServerInfo;
import com.x7.sdk.model.base.EncryptionBaseRequest;
import java.util.List;
import java.util.Objects;

public class GetServerLauncherNotifyEncryptionRequest extends EncryptionBaseRequest {

    /**
     * 区服列表
     */
    List<ServerInfo> serverList;

    public List<ServerInfo> getServerList() {
        return serverList;
    }

    public void setServerList(List<ServerInfo> serverList) {
        this.serverList = serverList;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetServerLauncherNotifyEncryptionRequest)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        GetServerLauncherNotifyEncryptionRequest that = (GetServerLauncherNotifyEncryptionRequest) o;
        return Objects.equals(serverList, that.serverList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), serverList);
    }

    @Override
    public String toString() {
        return "GetServerLauncherNotifyEncryptionRequest{" +
                "serverList=" + serverList +
                '}';
    }
}
