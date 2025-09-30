package com.x7.sdk.model.response;

import com.x7.sdk.model.UserRealNameInfo;
import java.util.List;
import java.util.Objects;

public class GetUserRealNameInfoResponse {
  List<UserRealNameInfo> userRealNameInfoList;

    public List<UserRealNameInfo> getUserRealNameInfoList() {
        return userRealNameInfoList;
    }

    public void setUserRealNameInfoList(List<UserRealNameInfo> userRealNameInfoList) {
        this.userRealNameInfoList = userRealNameInfoList;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetUserRealNameInfoResponse)) {
            return false;
        }
        GetUserRealNameInfoResponse response = (GetUserRealNameInfoResponse) o;
        return Objects.equals(userRealNameInfoList, response.userRealNameInfoList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userRealNameInfoList);
    }

    @Override
    public String toString() {
        return "GetUserRealNameInfoResponse{" +
                "userRealNameInfoList=" + userRealNameInfoList +
                '}';
    }
}
