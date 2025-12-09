package com.x7.sdk.model.request;

import com.x7.sdk.model.GameRoleInfo;
import com.x7.sdk.model.base.EncryptionBaseRequest;
import java.util.Objects;

public class GetGameRoleInfoReportEncryptionRequest extends EncryptionBaseRequest {

    /**
     * 角色信息 - 必填
     */
    GameRoleInfo role;

    public GameRoleInfo getRole() {
        return role;
    }

    public void setRole(GameRoleInfo role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetGameRoleInfoReportEncryptionRequest)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        GetGameRoleInfoReportEncryptionRequest that = (GetGameRoleInfoReportEncryptionRequest) o;
        return Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), role);
    }

    @Override
    public String toString() {
        return "GetGameRoleInfoReportEncryptionRequest{" +
                "role=" + role +
                '}';
    }
}
