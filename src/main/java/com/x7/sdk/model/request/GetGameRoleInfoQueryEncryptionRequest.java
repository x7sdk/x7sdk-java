package com.x7.sdk.model.request;

import com.x7.sdk.model.base.EncryptionBaseRequest;
import java.util.List;
import java.util.Objects;

public class GetGameRoleInfoQueryEncryptionRequest extends EncryptionBaseRequest {
    /**
     * 游戏角色ID
     */
    private String roleId;

    /**
     * 多个小7小号ID
     */
    private List<String> guids;

    /**
     * 区服ID
     */
    private String serverId;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getGuids() {
        return guids;
    }

    public void setGuids(List<String> guids) {
        this.guids = guids;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetGameRoleInfoQueryEncryptionRequest)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        GetGameRoleInfoQueryEncryptionRequest that = (GetGameRoleInfoQueryEncryptionRequest) o;
        return Objects.equals(roleId, that.roleId) && Objects.equals(guids, that.guids)
                && Objects.equals(serverId, that.serverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roleId, guids, serverId);
    }

    @Override
    public String toString() {
        return "GetGameRoleInfoQueryEncryptionRequest{" +
                "roleId='" + roleId + '\'' +
                ", guids=" + guids +
                ", serverId='" + serverId + '\'' +
                '}';
    }
}
