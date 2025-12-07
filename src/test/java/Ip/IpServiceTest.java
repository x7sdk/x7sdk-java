package Ip;

import com.x7.sdk.client.X7Client;
import com.x7.sdk.model.request.GetIpWhiteEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;
import com.x7.sdk.service.impl.IpServiceImpl;
import java.util.Arrays;
import org.junit.Test;

public class IpServiceTest {

    private String x7PublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBRKkJsJftrclIfT+2ueH3tkIa+BboTeeihEtL+1nLKdceSK2rQWjwru8Kbb9UuZgoJozD6/75cOhKuxlYWu347nkXx/GuYNqVjUXE1QYbI74KbAhcJCMGEsC8dPBs15vFrxEawKV63iHIBmGceM+vM+8JrnP0C7DVT0Z+c/g9gwIDAQAB";
    private String gamePrivate = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCk87LBB7pFXX0QOFY1MN7BeYkf71xt/e1LAwz8jVSwvK37V+K2x9atyLlhc4y6cygKDyvYweYQQV/6nSdZpZVsOWuAPjbWEienqOoVWQkgzL+JPeit40EVVuQOrEM2NxLQ/APQfZQaZfznbuazdVZB50BZ/gDwi2tfjgtKYJWX0kNSZEfgsmw78sQ07HuN5EAHloelD7KoqFL4igQg2FxRGjZs8C8AoZhdPL/uukTNpORoq2BqYbf6nqADkzzBn/ozGFCzVVXiP4c+LYXD+R3shGd4Dr49aUNvc3ZhfaMAzzJSgbPYdfzRs7Q3AlirjZKm/pdicos8iRtJaxTdJD0NAgMBAAECggEAJkKERrOlJ+usU3PNwx6nvFaVULvzQ2vve0Ok4nthlnDdJfxXkK+/gqWZIhpsHN8S/WpRcEBhPYn8WiPTeb6nbufOoHtNus+RNRk/2l3BeUMkdg/PBW49rVZvJVwdZtjVW3Xo6JYIIStgwsl9Z0ijDjw2N+lrjF+6Mvq+caz/Zaw2xgcQSwGYLSDsAbD3olG7Ih+jlAk2MJdIMTw/VtAP2f7nPyztmtiVkkM+G/pG5R/p2Kq8jrP0A+AQ4p4sYilYRFnqddRbdDzOOFw80vWe4VdNwOr3Ka/LtOVWGDNQPDuOlL4hQb9qKcWdyIQ4p46ncXoGpfrGRxog61Y7v86VwQKBgQDhfKomivYyKtQM6dJajOl5OpU97UnmbKlgXl+8XticYALWR2QbtbV4MQPNYXGyAB2wI1GHrIETJcwSXtLKbKYvsrBCHXdhKmDUvW3mX0tnAWi+z2SGbjwCIVxmoSKXdZdfp6qqACd6mEq27x0+s48/FWfryTU7NgzKpOtTn1ILkQKBgQC7RfmdiTynN9GmOR3HJvvL1rWTa2b6qxaHWZswhCbxxfc0hvPacPaGwPtryVlMd9PZGc6im3rHBX3Y3FwXUUrJ/BEcLi4Y8zaVLhGAHcDuzCa0de1/FhP8qpSCobK6lHeeqESoEXQmWn1S7pH4rYRyuOvVR6vi4YNFHZD/ov8DvQKBgDjpOxTBTAQ7dQvRVCtQl3jmhVZ89oL2+AT/rNAhbDCDtxOYLzcjNKsiS+BhcM3JY7TaJTDGJEnN52TXlAJNS+CMDBqTz1ax2IC5UuyrLp/P5j0KoUeguPqcqvKoRs/NeShGbDe+FDjICUuErG/v5/63C2SigxHvwWjAGTkg5BdRAoGBAIRWZpaUrG/eWiCErC5XtgfNqnKKqzLoQ/tRrwER4hNoOdC8rQXoXc3MAd+hYaFP7Dy2p/bwuEp77vqYfdtcbuVdYxnu6FRpSmERNPy8CeK2EYPk8fekumsKf/fwHEUNNZrAfgPmkZWozHcWb8Czna0UUFNfWm/xvLnSsuxzWpJhAoGAUqzQWQ3q26kLMaLdaMzu+iYtP+YpasWzynpYM03NEXbl5QZXHzm3STygDqPJVLI4TXlWLkSBOgeIa5mPCytDIur+WBd6z4Ix1cWLVCob9ZPsLqDgV16Q90uSlsXFmMO7BSGgb2U+oJXvdwjcRTeaJHeOwglm+a1hIzKPweCXK/M=";


    @Test
    public void testEncryptIpWhiteListRequest() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            IpServiceImpl ipService = client.getIpService();

            GetIpWhiteEncryptionRequest request = new GetIpWhiteEncryptionRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime(new java.util.Date().toInstant().toString());
            request.setIpType("client");
            request.setIpList(Arrays.asList("192.168.1.1", "192.168.1.2"));

            MethodCommonReqResponse response = ipService.encryptIpWhiteListRequest(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDecryptIpWhiteListResponse() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            IpServiceImpl ipService = client.getIpService();

            MethodCommonRespVerifyRequestBO request = new MethodCommonRespVerifyRequestBO();
            request.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setRespTime("2025-12-07T22:49:18+0800");
            request.setBizResp(
                    "{\"respCode\":\"FAIL\",\"respMsg\":\"尚未设置白名单IP（RequestId: 815ED51F-06F5-7096-1639-8A8F164E2535）\"}");
            request.setSignature(
                    "oThzfAoLzvH3oVuU1ei0xq51LinmJ1EMR7oXiQw6/+o3A9bSezTitajzcR9i/PMBuK9aKg4khxMBp6X3FyZjU+mzSO/wZrLEmAZxCKpzlDWZoRDGdVrXgNsxkeGtuI2KcGom84j00Y5+13kjYQmlKrGY0+YCl6WPHPnQ/Tm8JAE=");

            SignatureVerifyCommonResponse response = ipService.decryptIpWhiteListResponse(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
