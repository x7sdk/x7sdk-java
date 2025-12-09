package Server;

import com.x7.sdk.client.X7Client;
import com.x7.sdk.model.ServerInfo;
import com.x7.sdk.model.request.GetServerLauncherNotifyEncryptionRequest;
import com.x7.sdk.model.request.GetServerLauncherQueryEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;
import com.x7.sdk.service.impl.ServerLauncherServiceImpl;
import java.util.Arrays;
import org.junit.Test;

public class ServerLauncherServiceTest {

    private String x7PublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBRKkJsJftrclIfT+2ueH3tkIa+BboTeeihEtL+1nLKdceSK2rQWjwru8Kbb9UuZgoJozD6/75cOhKuxlYWu347nkXx/GuYNqVjUXE1QYbI74KbAhcJCMGEsC8dPBs15vFrxEawKV63iHIBmGceM+vM+8JrnP0C7DVT0Z+c/g9gwIDAQAB";
    private String gamePrivate = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCk87LBB7pFXX0QOFY1MN7BeYkf71xt/e1LAwz8jVSwvK37V+K2x9atyLlhc4y6cygKDyvYweYQQV/6nSdZpZVsOWuAPjbWEienqOoVWQkgzL+JPeit40EVVuQOrEM2NxLQ/APQfZQaZfznbuazdVZB50BZ/gDwi2tfjgtKYJWX0kNSZEfgsmw78sQ07HuN5EAHloelD7KoqFL4igQg2FxRGjZs8C8AoZhdPL/uukTNpORoq2BqYbf6nqADkzzBn/ozGFCzVVXiP4c+LYXD+R3shGd4Dr49aUNvc3ZhfaMAzzJSgbPYdfzRs7Q3AlirjZKm/pdicos8iRtJaxTdJD0NAgMBAAECggEAJkKERrOlJ+usU3PNwx6nvFaVULvzQ2vve0Ok4nthlnDdJfxXkK+/gqWZIhpsHN8S/WpRcEBhPYn8WiPTeb6nbufOoHtNus+RNRk/2l3BeUMkdg/PBW49rVZvJVwdZtjVW3Xo6JYIIStgwsl9Z0ijDjw2N+lrjF+6Mvq+caz/Zaw2xgcQSwGYLSDsAbD3olG7Ih+jlAk2MJdIMTw/VtAP2f7nPyztmtiVkkM+G/pG5R/p2Kq8jrP0A+AQ4p4sYilYRFnqddRbdDzOOFw80vWe4VdNwOr3Ka/LtOVWGDNQPDuOlL4hQb9qKcWdyIQ4p46ncXoGpfrGRxog61Y7v86VwQKBgQDhfKomivYyKtQM6dJajOl5OpU97UnmbKlgXl+8XticYALWR2QbtbV4MQPNYXGyAB2wI1GHrIETJcwSXtLKbKYvsrBCHXdhKmDUvW3mX0tnAWi+z2SGbjwCIVxmoSKXdZdfp6qqACd6mEq27x0+s48/FWfryTU7NgzKpOtTn1ILkQKBgQC7RfmdiTynN9GmOR3HJvvL1rWTa2b6qxaHWZswhCbxxfc0hvPacPaGwPtryVlMd9PZGc6im3rHBX3Y3FwXUUrJ/BEcLi4Y8zaVLhGAHcDuzCa0de1/FhP8qpSCobK6lHeeqESoEXQmWn1S7pH4rYRyuOvVR6vi4YNFHZD/ov8DvQKBgDjpOxTBTAQ7dQvRVCtQl3jmhVZ89oL2+AT/rNAhbDCDtxOYLzcjNKsiS+BhcM3JY7TaJTDGJEnN52TXlAJNS+CMDBqTz1ax2IC5UuyrLp/P5j0KoUeguPqcqvKoRs/NeShGbDe+FDjICUuErG/v5/63C2SigxHvwWjAGTkg5BdRAoGBAIRWZpaUrG/eWiCErC5XtgfNqnKKqzLoQ/tRrwER4hNoOdC8rQXoXc3MAd+hYaFP7Dy2p/bwuEp77vqYfdtcbuVdYxnu6FRpSmERNPy8CeK2EYPk8fekumsKf/fwHEUNNZrAfgPmkZWozHcWb8Czna0UUFNfWm/xvLnSsuxzWpJhAoGAUqzQWQ3q26kLMaLdaMzu+iYtP+YpasWzynpYM03NEXbl5QZXHzm3STygDqPJVLI4TXlWLkSBOgeIa5mPCytDIur+WBd6z4Ix1cWLVCob9ZPsLqDgV16Q90uSlsXFmMO7BSGgb2U+oJXvdwjcRTeaJHeOwglm+a1hIzKPweCXK/M=";


    @Test
    public void testEncryptServerLauncherQueryRequest() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            ServerLauncherServiceImpl serverLauncherService = client.getServerLauncherService();

            GetServerLauncherQueryEncryptionRequest request = new GetServerLauncherQueryEncryptionRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime(new java.util.Date().toInstant().toString());
            request.setStartTime("2025-01-01T00:00:00+0800");
            request.setEndTime("2025-12-31T23:59:59+0800");

            MethodCommonReqResponse response = serverLauncherService.encryptServerLauncherQueryRequest(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDecryptServerLauncherQueryResponse() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            ServerLauncherServiceImpl serverLauncherService = client.getServerLauncherService();

            MethodCommonRespVerifyRequestBO request = new MethodCommonRespVerifyRequestBO();
            request.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setRespTime("2025-12-07T22:59:27+0800");
            request.setBizResp(
                    "{\"serverList\":[{\"serverId\":\"1\",\"serverTime\":\"2025-02-06T11:59:59+0800\",\"serverName\":\"区服1\",\"apiServer\":\"\"},{\"serverId\":\"2\",\"serverTime\":\"2025-03-14T23:59:59+0800\",\"serverName\":\"区服2\",\"apiServer\":\"\"},{\"serverId\":\"3\",\"serverTime\":\"2025-04-20T11:59:59+0800\",\"serverName\":\"区服3\",\"apiServer\":\"\"},{\"serverId\":\"4\",\"serverTime\":\"2025-05-26T23:59:59+0800\",\"serverName\":\"区服4\",\"apiServer\":\"\"},{\"serverId\":\"5\",\"serverTime\":\"2025-07-02T11:59:59+0800\",\"serverName\":\"区服5\",\"apiServer\":\"\"},{\"serverId\":\"6\",\"serverTime\":\"2025-08-07T23:59:59+0800\",\"serverName\":\"区服6\",\"apiServer\":\"\"},{\"serverId\":\"7\",\"serverTime\":\"2025-09-13T11:59:59+0800\",\"serverName\":\"区服7\",\"apiServer\":\"\"},{\"serverId\":\"8\",\"serverTime\":\"2025-10-19T23:59:59+0800\",\"serverName\":\"区服8\",\"apiServer\":\"\"},{\"serverId\":\"9\",\"serverTime\":\"2025-11-25T11:59:59+0800\",\"serverName\":\"区服9\",\"apiServer\":\"\"},{\"serverId\":\"10\",\"serverTime\":\"2025-12-31T23:59:59+0800\",\"serverName\":\"区服10\",\"apiServer\":\"\"}],\"respCode\":\"SUCCESS\",\"respMsg\":\"\"}");
            request.setSignature(
                    "Mpk/kJ4l810qhC8+5fNdxWxVgPvy2MROVlUfMfBCuO6ily/ny1k7zS9SuipwuX6sGAn1GNR/oOI8sBjKk1b9F1cgva9tGmm8dZe5hQS9HJt27++/hVNRik4+mbYYzXOqoYMxrF4A2qR3Z0VJkfWQ3CLmFJ5tEPvaVmBsDGNcUpY=");

            SignatureVerifyCommonResponse response = serverLauncherService.decryptServerLauncherQueryResponse(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEncryptServerLauncherNotifyRequest() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            ServerLauncherServiceImpl serverLauncherService = client.getServerLauncherService();

            GetServerLauncherNotifyEncryptionRequest request = new GetServerLauncherNotifyEncryptionRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime(new java.util.Date().toInstant().toString());
            ServerInfo serverInfo = new ServerInfo();
            serverInfo.setServerId("1");
            serverInfo.setServerTime("2025-02-06T11:59:59+0800");
            serverInfo.setServerName("区服1");
            serverInfo.setApiServer("");
            request.setServerList(Arrays.asList(serverInfo));

            MethodCommonReqResponse response = serverLauncherService.encryptServerLauncherNotifyRequest(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDecryptServerLauncherNotifyResponse() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            ServerLauncherServiceImpl serverLauncherService = client.getServerLauncherService();

            MethodCommonRespVerifyRequestBO request = new MethodCommonRespVerifyRequestBO();
            request.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setRespTime("2025-12-07T23:04:03+0800");
            request.setBizResp("{\"respCode\":\"SUCCESS\",\"respMsg\":\"\"}");
            request.setSignature(
                    "tQiGP+a0nk+D6v4hUMMuLbtfo+p7CCQL7XXl79MP0xhiFV/ZPU+gBx//ozz2x/cDKdwkS+bonWg1miS+TO0JTkdbG1CVsOZBWov14tyHbtpb95JNJgSVJX0VmUaeIxhI2jzsrV8kXD0gGNBXFzJKzVnBbq7Ghhv7/9G8+sgSoeI=");

            SignatureVerifyCommonResponse response = serverLauncherService.decryptServerLauncherNotifyResponse(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
