package com.x7.sdk.service;

import com.x7.sdk.model.request.GameRoleReportResultVerifyRequest;
import com.x7.sdk.model.request.GetGameRoleReportSignRequest;
import com.x7.sdk.model.response.GameRoleReportResultVerifyResponse;
import com.x7.sdk.model.response.GetGameRoleReportSignResponse;

public interface GameInfoService {

    GetGameRoleReportSignResponse getGameRoleReportSign(GetGameRoleReportSignRequest request);

    GameRoleReportResultVerifyResponse getGameRoleReportVerifyResult(GameRoleReportResultVerifyRequest request);
}
