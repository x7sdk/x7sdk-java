package com.x7.sdk.model.response;

import java.util.Objects;

public class SignatureVerifyCommonResponse {
    private boolean isValid;

    public SignatureVerifyCommonResponse() {
    }

    public SignatureVerifyCommonResponse(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "SignatureVerifyCommonResponse{" +
                "isValid=" + isValid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SignatureVerifyCommonResponse)) {
            return false;
        }
        SignatureVerifyCommonResponse that = (SignatureVerifyCommonResponse) o;
        return isValid == that.isValid;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isValid);
    }
}
