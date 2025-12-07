package game;

import com.x7.sdk.client.X7Client;
import com.x7.sdk.model.request.GetPaymentOrderQueryEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;
import com.x7.sdk.service.impl.GameOrderServiceImpl;
import org.junit.Test;

public class GameOrderServiceTest {

    private String x7PublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBRKkJsJftrclIfT+2ueH3tkIa+BboTeeihEtL+1nLKdceSK2rQWjwru8Kbb9UuZgoJozD6/75cOhKuxlYWu347nkXx/GuYNqVjUXE1QYbI74KbAhcJCMGEsC8dPBs15vFrxEawKV63iHIBmGceM+vM+8JrnP0C7DVT0Z+c/g9gwIDAQAB";
    private String gamePrivate = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCk87LBB7pFXX0QOFY1MN7BeYkf71xt/e1LAwz8jVSwvK37V+K2x9atyLlhc4y6cygKDyvYweYQQV/6nSdZpZVsOWuAPjbWEienqOoVWQkgzL+JPeit40EVVuQOrEM2NxLQ/APQfZQaZfznbuazdVZB50BZ/gDwi2tfjgtKYJWX0kNSZEfgsmw78sQ07HuN5EAHloelD7KoqFL4igQg2FxRGjZs8C8AoZhdPL/uukTNpORoq2BqYbf6nqADkzzBn/ozGFCzVVXiP4c+LYXD+R3shGd4Dr49aUNvc3ZhfaMAzzJSgbPYdfzRs7Q3AlirjZKm/pdicos8iRtJaxTdJD0NAgMBAAECggEAJkKERrOlJ+usU3PNwx6nvFaVULvzQ2vve0Ok4nthlnDdJfxXkK+/gqWZIhpsHN8S/WpRcEBhPYn8WiPTeb6nbufOoHtNus+RNRk/2l3BeUMkdg/PBW49rVZvJVwdZtjVW3Xo6JYIIStgwsl9Z0ijDjw2N+lrjF+6Mvq+caz/Zaw2xgcQSwGYLSDsAbD3olG7Ih+jlAk2MJdIMTw/VtAP2f7nPyztmtiVkkM+G/pG5R/p2Kq8jrP0A+AQ4p4sYilYRFnqddRbdDzOOFw80vWe4VdNwOr3Ka/LtOVWGDNQPDuOlL4hQb9qKcWdyIQ4p46ncXoGpfrGRxog61Y7v86VwQKBgQDhfKomivYyKtQM6dJajOl5OpU97UnmbKlgXl+8XticYALWR2QbtbV4MQPNYXGyAB2wI1GHrIETJcwSXtLKbKYvsrBCHXdhKmDUvW3mX0tnAWi+z2SGbjwCIVxmoSKXdZdfp6qqACd6mEq27x0+s48/FWfryTU7NgzKpOtTn1ILkQKBgQC7RfmdiTynN9GmOR3HJvvL1rWTa2b6qxaHWZswhCbxxfc0hvPacPaGwPtryVlMd9PZGc6im3rHBX3Y3FwXUUrJ/BEcLi4Y8zaVLhGAHcDuzCa0de1/FhP8qpSCobK6lHeeqESoEXQmWn1S7pH4rYRyuOvVR6vi4YNFHZD/ov8DvQKBgDjpOxTBTAQ7dQvRVCtQl3jmhVZ89oL2+AT/rNAhbDCDtxOYLzcjNKsiS+BhcM3JY7TaJTDGJEnN52TXlAJNS+CMDBqTz1ax2IC5UuyrLp/P5j0KoUeguPqcqvKoRs/NeShGbDe+FDjICUuErG/v5/63C2SigxHvwWjAGTkg5BdRAoGBAIRWZpaUrG/eWiCErC5XtgfNqnKKqzLoQ/tRrwER4hNoOdC8rQXoXc3MAd+hYaFP7Dy2p/bwuEp77vqYfdtcbuVdYxnu6FRpSmERNPy8CeK2EYPk8fekumsKf/fwHEUNNZrAfgPmkZWozHcWb8Czna0UUFNfWm/xvLnSsuxzWpJhAoGAUqzQWQ3q26kLMaLdaMzu+iYtP+YpasWzynpYM03NEXbl5QZXHzm3STygDqPJVLI4TXlWLkSBOgeIa5mPCytDIur+WBd6z4Ix1cWLVCob9ZPsLqDgV16Q90uSlsXFmMO7BSGgb2U+oJXvdwjcRTeaJHeOwglm+a1hIzKPweCXK/M=";

    @Test
    public void testEncryptPaymentOrderQueryRequest() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            GameOrderServiceImpl gameOrderService = client.getGameOrderService();

            GetPaymentOrderQueryEncryptionRequest request = new GetPaymentOrderQueryEncryptionRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime(new java.util.Date().toInstant().toString());
            request.setStartTime("2025-01-01T00:00:00+0800");
            request.setEndTime("2025-01-01T23:59:59+0800");

            MethodCommonReqResponse response = gameOrderService.encryptPaymentOrderQueryRequest(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDecryptPaymentOrderQueryResponse() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            GameOrderServiceImpl gameOrderService = client.getGameOrderService();

            MethodCommonRespVerifyRequestBO request = new MethodCommonRespVerifyRequestBO();
            request.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setRespTime("2025-12-07T23:13:58+0800");
            request.setBizResp(
                    "{\"orderList\":[{\"goid\":\"12345\",\"gameOrderId\":\"abcdef12345\",\"guid\":\"123\",\"gamePrice\":\"100.00\",\"payPrice\":\"80.00\",\"subject\":\"钻石*100\",\"orderFrom\":\"1\",\"createTime\":\"2025-12-07T23:13:58+0800\",\"payTime\":\"2025-12-07T23:13:59+0800\",\"couponDeductPrice\":\"0.00\",\"rechargeCardDeductPrice\":\"20.00\",\"rechargeCardRewardDeductPrice\":\"10.00\",\"arenaId\":\"234\"},{\"goid\":\"14345\",\"gameOrderId\":\"X7NCD12345\",\"guid\":\"1234\",\"gamePrice\":\"100.00\",\"payPrice\":\"60.00\",\"subject\":\"元宝*100\",\"orderFrom\":\"1\",\"createTime\":\"2025-12-07T23:13:58+0800\",\"payTime\":\"2025-12-07T23:13:59+0800\",\"couponDeductPrice\":\"40.00\",\"rechargeCardDeductPrice\":\"0.00\",\"rechargeCardRewardDeductPrice\":\"0.00\",\"arenaId\":\"223\"}],\"respCode\":\"SUCCESS\",\"respMsg\":\"\"}");
            request.setSignature(
                    "tACzcGPKoXCXI9EyhTd0Y8iXHBfAcrargQ6bODrZxlGuoTT4lSbVVFBRElASOJxnUK+drpEjJJKkQUp2gW+h6TiGNGu2K3KNJbIgzctLnuiT4v7Yzx29Sp2NI8FIb9d6O+Qom9VO1A5Jxf/rBAhvUAeRNVW1bv/lF3kNpFZuJhA=");

            SignatureVerifyCommonResponse response = gameOrderService.decryptPaymentOrderQueryResponse(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
