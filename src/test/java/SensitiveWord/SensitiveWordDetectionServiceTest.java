package SensitiveWord;

import com.x7.sdk.client.X7Client;
import com.x7.sdk.model.request.GetHandleMethodReportEncryptionRequest;
import com.x7.sdk.model.request.GetInfoDetectionEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;
import com.x7.sdk.service.impl.SensitiveWordDetectionServiceImpl;
import org.junit.Test;

public class SensitiveWordDetectionServiceTest {
    private String x7PublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBRKkJsJftrclIfT+2ueH3tkIa+BboTeeihEtL+1nLKdceSK2rQWjwru8Kbb9UuZgoJozD6/75cOhKuxlYWu347nkXx/GuYNqVjUXE1QYbI74KbAhcJCMGEsC8dPBs15vFrxEawKV63iHIBmGceM+vM+8JrnP0C7DVT0Z+c/g9gwIDAQAB";
    private String gamePrivate = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCk87LBB7pFXX0QOFY1MN7BeYkf71xt/e1LAwz8jVSwvK37V+K2x9atyLlhc4y6cygKDyvYweYQQV/6nSdZpZVsOWuAPjbWEienqOoVWQkgzL+JPeit40EVVuQOrEM2NxLQ/APQfZQaZfznbuazdVZB50BZ/gDwi2tfjgtKYJWX0kNSZEfgsmw78sQ07HuN5EAHloelD7KoqFL4igQg2FxRGjZs8C8AoZhdPL/uukTNpORoq2BqYbf6nqADkzzBn/ozGFCzVVXiP4c+LYXD+R3shGd4Dr49aUNvc3ZhfaMAzzJSgbPYdfzRs7Q3AlirjZKm/pdicos8iRtJaxTdJD0NAgMBAAECggEAJkKERrOlJ+usU3PNwx6nvFaVULvzQ2vve0Ok4nthlnDdJfxXkK+/gqWZIhpsHN8S/WpRcEBhPYn8WiPTeb6nbufOoHtNus+RNRk/2l3BeUMkdg/PBW49rVZvJVwdZtjVW3Xo6JYIIStgwsl9Z0ijDjw2N+lrjF+6Mvq+caz/Zaw2xgcQSwGYLSDsAbD3olG7Ih+jlAk2MJdIMTw/VtAP2f7nPyztmtiVkkM+G/pG5R/p2Kq8jrP0A+AQ4p4sYilYRFnqddRbdDzOOFw80vWe4VdNwOr3Ka/LtOVWGDNQPDuOlL4hQb9qKcWdyIQ4p46ncXoGpfrGRxog61Y7v86VwQKBgQDhfKomivYyKtQM6dJajOl5OpU97UnmbKlgXl+8XticYALWR2QbtbV4MQPNYXGyAB2wI1GHrIETJcwSXtLKbKYvsrBCHXdhKmDUvW3mX0tnAWi+z2SGbjwCIVxmoSKXdZdfp6qqACd6mEq27x0+s48/FWfryTU7NgzKpOtTn1ILkQKBgQC7RfmdiTynN9GmOR3HJvvL1rWTa2b6qxaHWZswhCbxxfc0hvPacPaGwPtryVlMd9PZGc6im3rHBX3Y3FwXUUrJ/BEcLi4Y8zaVLhGAHcDuzCa0de1/FhP8qpSCobK6lHeeqESoEXQmWn1S7pH4rYRyuOvVR6vi4YNFHZD/ov8DvQKBgDjpOxTBTAQ7dQvRVCtQl3jmhVZ89oL2+AT/rNAhbDCDtxOYLzcjNKsiS+BhcM3JY7TaJTDGJEnN52TXlAJNS+CMDBqTz1ax2IC5UuyrLp/P5j0KoUeguPqcqvKoRs/NeShGbDe+FDjICUuErG/v5/63C2SigxHvwWjAGTkg5BdRAoGBAIRWZpaUrG/eWiCErC5XtgfNqnKKqzLoQ/tRrwER4hNoOdC8rQXoXc3MAd+hYaFP7Dy2p/bwuEp77vqYfdtcbuVdYxnu6FRpSmERNPy8CeK2EYPk8fekumsKf/fwHEUNNZrAfgPmkZWozHcWb8Czna0UUFNfWm/xvLnSsuxzWpJhAoGAUqzQWQ3q26kLMaLdaMzu+iYtP+YpasWzynpYM03NEXbl5QZXHzm3STygDqPJVLI4TXlWLkSBOgeIa5mPCytDIur+WBd6z4Ix1cWLVCob9ZPsLqDgV16Q90uSlsXFmMO7BSGgb2U+oJXvdwjcRTeaJHeOwglm+a1hIzKPweCXK/M=";

    @Test
    public void testEncryptDetectionRequest() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            SensitiveWordDetectionServiceImpl sensitiveWordService = client.getSensitiveWordDetectionService();

            GetInfoDetectionEncryptionRequest request = new GetInfoDetectionEncryptionRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime(new java.util.Date().toInstant().toString());
            // 根据实际需求设置其他必要参数
             request.setDetectionMessage("测试敏感词wa内容");
             request.setGuid("71272354");

            MethodCommonReqResponse response = sensitiveWordService.encryptDetectionRequest(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDecryptDetectionResult() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            SensitiveWordDetectionServiceImpl sensitiveWordService = client.getSensitiveWordDetectionService();

            MethodCommonRespVerifyRequestBO request = new MethodCommonRespVerifyRequestBO();
            request.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setRespTime("2025-12-08T10:27:37+0800");
            request.setBizResp("{\"detectResult\":{\"detectionLogId\":5512,\"level\":1,\"labelCode\":0,\"sensitiveWords\":[]},\"respCode\":\"SUCCESS\",\"respMsg\":\"检测成功~\"}");
            request.setSignature("FI0Q7rkioe3XoNdFcueLvBspBK8rzATGx1KYI3U/NzSS4vrNbHH/vDRnwqpAa2/NrkKKgm4R+aFs8BwuSfUN620ffLUdzJD0NoYZ+Op4FkrTiZLcC38BVhdSJ7g9VLwVowgGoAwgwmi67fxXDqce/oWS+nnLENBUobFc+daZ1Dk=");

            SignatureVerifyCommonResponse response = sensitiveWordService.decryptDetectionResult(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEncryptReportRequest() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            SensitiveWordDetectionServiceImpl sensitiveWordService = client.getSensitiveWordDetectionService();

            GetHandleMethodReportEncryptionRequest request = new GetHandleMethodReportEncryptionRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime(new java.util.Date().toInstant().toString());
            // 根据实际需求设置其他必要参数
             request.setDetectionLogId("5512");
             request.setOperateType("2");

            MethodCommonReqResponse response = sensitiveWordService.encryptReportRequest(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDecryptReportResponse() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            SensitiveWordDetectionServiceImpl sensitiveWordService = client.getSensitiveWordDetectionService();

            MethodCommonRespVerifyRequestBO request = new MethodCommonRespVerifyRequestBO();
            request.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setRespTime("2025-12-08T10:38:04+0800");
            request.setBizResp("{\"respCode\":\"SUCCESS\",\"respMsg\":\"上报成功~\"}");
            request.setSignature("EYyg4Ooz70q70lTu4umElv5zf6OOJNvFonUd3TmzV7+YgNmFoabhrQj+DxmZ8hqElfyrmGSf6pSivMH0llnM1lDJsONTd0EXlDNtfAbVnnzXVlo30mEhG1PKycCojx35cgrMGyKrrN65781s6t15m+PHO6rCXjNLGV3BptL5TGU=");

            SignatureVerifyCommonResponse response = sensitiveWordService.decryptReportResponse(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
