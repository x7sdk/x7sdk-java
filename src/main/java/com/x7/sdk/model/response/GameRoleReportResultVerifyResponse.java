package com.x7.sdk.model.response;

import java.util.Objects;

public class GameRoleReportResultVerifyResponse {
    Boolean isValid;

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GameRoleReportResultVerifyResponse)) {
            return false;
        }
        GameRoleReportResultVerifyResponse that = (GameRoleReportResultVerifyResponse) o;
        return Objects.equals(isValid, that.isValid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isValid);
    }

    @Override
    public String toString() {
        return "GameRoleReportResultVerifyResponse{" +
                "isValid=" + isValid +
                '}';
    }
}
