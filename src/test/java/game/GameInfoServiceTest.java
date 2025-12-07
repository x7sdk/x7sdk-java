package game;

import com.x7.sdk.client.X7Client;
import com.x7.sdk.model.GameRoleInfo;
import com.x7.sdk.model.request.GameRoleReportResultVerifyRequest;
import com.x7.sdk.model.request.GetGameRoleInfoQueryEncryptionRequest;
import com.x7.sdk.model.request.GetGameRoleReportSignRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.GameRoleReportResultVerifyResponse;
import com.x7.sdk.model.response.GetGameRoleReportSignResponse;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;
import com.x7.sdk.service.impl.GameInfoServiceImpl;
import java.util.Arrays;
import org.junit.Test;

public class GameInfoServiceTest {

    private String x7PublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBRKkJsJftrclIfT+2ueH3tkIa+BboTeeihEtL+1nLKdceSK2rQWjwru8Kbb9UuZgoJozD6/75cOhKuxlYWu347nkXx/GuYNqVjUXE1QYbI74KbAhcJCMGEsC8dPBs15vFrxEawKV63iHIBmGceM+vM+8JrnP0C7DVT0Z+c/g9gwIDAQAB";
    private String gamePrivate = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCk87LBB7pFXX0QOFY1MN7BeYkf71xt/e1LAwz8jVSwvK37V+K2x9atyLlhc4y6cygKDyvYweYQQV/6nSdZpZVsOWuAPjbWEienqOoVWQkgzL+JPeit40EVVuQOrEM2NxLQ/APQfZQaZfznbuazdVZB50BZ/gDwi2tfjgtKYJWX0kNSZEfgsmw78sQ07HuN5EAHloelD7KoqFL4igQg2FxRGjZs8C8AoZhdPL/uukTNpORoq2BqYbf6nqADkzzBn/ozGFCzVVXiP4c+LYXD+R3shGd4Dr49aUNvc3ZhfaMAzzJSgbPYdfzRs7Q3AlirjZKm/pdicos8iRtJaxTdJD0NAgMBAAECggEAJkKERrOlJ+usU3PNwx6nvFaVULvzQ2vve0Ok4nthlnDdJfxXkK+/gqWZIhpsHN8S/WpRcEBhPYn8WiPTeb6nbufOoHtNus+RNRk/2l3BeUMkdg/PBW49rVZvJVwdZtjVW3Xo6JYIIStgwsl9Z0ijDjw2N+lrjF+6Mvq+caz/Zaw2xgcQSwGYLSDsAbD3olG7Ih+jlAk2MJdIMTw/VtAP2f7nPyztmtiVkkM+G/pG5R/p2Kq8jrP0A+AQ4p4sYilYRFnqddRbdDzOOFw80vWe4VdNwOr3Ka/LtOVWGDNQPDuOlL4hQb9qKcWdyIQ4p46ncXoGpfrGRxog61Y7v86VwQKBgQDhfKomivYyKtQM6dJajOl5OpU97UnmbKlgXl+8XticYALWR2QbtbV4MQPNYXGyAB2wI1GHrIETJcwSXtLKbKYvsrBCHXdhKmDUvW3mX0tnAWi+z2SGbjwCIVxmoSKXdZdfp6qqACd6mEq27x0+s48/FWfryTU7NgzKpOtTn1ILkQKBgQC7RfmdiTynN9GmOR3HJvvL1rWTa2b6qxaHWZswhCbxxfc0hvPacPaGwPtryVlMd9PZGc6im3rHBX3Y3FwXUUrJ/BEcLi4Y8zaVLhGAHcDuzCa0de1/FhP8qpSCobK6lHeeqESoEXQmWn1S7pH4rYRyuOvVR6vi4YNFHZD/ov8DvQKBgDjpOxTBTAQ7dQvRVCtQl3jmhVZ89oL2+AT/rNAhbDCDtxOYLzcjNKsiS+BhcM3JY7TaJTDGJEnN52TXlAJNS+CMDBqTz1ax2IC5UuyrLp/P5j0KoUeguPqcqvKoRs/NeShGbDe+FDjICUuErG/v5/63C2SigxHvwWjAGTkg5BdRAoGBAIRWZpaUrG/eWiCErC5XtgfNqnKKqzLoQ/tRrwER4hNoOdC8rQXoXc3MAd+hYaFP7Dy2p/bwuEp77vqYfdtcbuVdYxnu6FRpSmERNPy8CeK2EYPk8fekumsKf/fwHEUNNZrAfgPmkZWozHcWb8Czna0UUFNfWm/xvLnSsuxzWpJhAoGAUqzQWQ3q26kLMaLdaMzu+iYtP+YpasWzynpYM03NEXbl5QZXHzm3STygDqPJVLI4TXlWLkSBOgeIa5mPCytDIur+WBd6z4Ix1cWLVCob9ZPsLqDgV16Q90uSlsXFmMO7BSGgb2U+oJXvdwjcRTeaJHeOwglm+a1hIzKPweCXK/M=";

    @Test
    public void testGameRoleReportSign() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            GameInfoServiceImpl gameInfoService = client.getGameInfoService();

            GetGameRoleReportSignRequest request = new GetGameRoleReportSignRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime(new java.util.Date().toInstant().toString());
            // 设置角色信息
            GameRoleInfo roleInfo = new GameRoleInfo();
            roleInfo.setRoleId("role123");
            roleInfo.setRoleName("TestRole");
            roleInfo.setRoleLevel("10");
            roleInfo.setServerId("server1");
            roleInfo.setServerName("TestServer");
            roleInfo.setRoleRechargeAmount(100.0);
            roleInfo.setServerName("test");
            roleInfo.setRoleGuild("71268837");
            roleInfo.setRoleCE("100");
            roleInfo.setRoleStage("test");
            roleInfo.setGuid("71268837");
            request.setRole(roleInfo);

            GetGameRoleReportSignResponse gameRoleReportSign = gameInfoService.getGameRoleReportSign(request);
            System.out.println(gameRoleReportSign);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getGameRoleReportVerifyResult() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            GameInfoServiceImpl gameInfoService = client.getGameInfoService();

            GameRoleReportResultVerifyRequest request = new GameRoleReportResultVerifyRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime("2025-09-29T16:11:37+0800");
            request.setBizResp("{\"respCode\":\"SUCCESS\",\"respMsg\":\"\"}");
            request.setSignature("PFMjldPuURhD769KoH/nhDZUZOba0yykgKnYRGPTgGZGtYkZ6IF6yDU1bc9IuuhQd9f46VoPzZIwbR/1ZviDt0jvkWFaqFmp/boFblVp3sGVWNj7T3FFOKwCqF7tN7+tl97v+Pcx0+Xgs89gQOEm6QEzb1AyLSv6tir9xuSsdKQ=");
            request.setApiMethod("common.roleReport");

            GameRoleReportResultVerifyResponse result = gameInfoService.getGameRoleReportVerifyResult(request);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void encryptGameRoleInfoQueryRequest() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            GameInfoServiceImpl gameInfoService = client.getGameInfoService();

            GetGameRoleInfoQueryEncryptionRequest request = new GetGameRoleInfoQueryEncryptionRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime(new java.util.Date().toInstant().toString());
            // 设置角色信息
            request.setRoleId("role123");
            request.setServerId("server1");
            request.setGuids(Arrays.asList("71268837"));

            MethodCommonReqResponse response = gameInfoService.encryptGameRoleInfoQueryRequest(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void decryptGameRoleInfoQueryResponse() {
        X7Client client = new X7Client(x7PublicKey, gamePrivate);
        GameInfoServiceImpl gameInfoService = client.getGameInfoService();

        MethodCommonRespVerifyRequestBO request = new MethodCommonRespVerifyRequestBO();
        request.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
        request.setGameType("client");
        request.setRespTime("2025-12-07T22:39:29+0800");
        request.setBizResp("{\"respCode\":\"FAIL\",\"respMsg\":\"角色信息不存在（RequestId: 59260A61-AAD0-0769-D962-910CA55AA057）\"}");
        request.setSignature("IMjQ4QENOszR4QntyJuZix6ZDeCLOrqrIcJTebQNsMLa/74DWO+2SFc7zDR3E1cDmCdXLrLnLHAIF47NL95cF0ij+6W3ASke6KRHu1//HtAg3b50sKtbH/rJL6iwnDt9r8cLaQSAqugQTJ/N+0gGVsgdmP/938KCAdNeBP4JjSw=");

        SignatureVerifyCommonResponse response = gameInfoService.decryptGameRoleInfoQueryResponse(request);
        System.out.println(response);
    }
}
