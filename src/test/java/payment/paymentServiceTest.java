package payment;

import com.x7.sdk.client.X7Client;
import com.x7.sdk.model.request.PaymentOrderCallbackVerifyRequest;
import com.x7.sdk.model.request.PaymentOrderEncryptedRequest;
import com.x7.sdk.model.response.PaymentOrderCallbackVerifyResponse;
import com.x7.sdk.model.response.PaymentOrderEncryptedResponse;
import com.x7.sdk.service.PaymentService;
import org.junit.Test;

public class paymentServiceTest {

    private String x7PublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBRKkJsJftrclIfT+2ueH3tkIa+BboTeeihEtL+1nLKdceSK2rQWjwru8Kbb9UuZgoJozD6/75cOhKuxlYWu347nkXx/GuYNqVjUXE1QYbI74KbAhcJCMGEsC8dPBs15vFrxEawKV63iHIBmGceM+vM+8JrnP0C7DVT0Z+c/g9gwIDAQAB";
    private String gamePrivate = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCk87LBB7pFXX0QOFY1MN7BeYkf71xt/e1LAwz8jVSwvK37V+K2x9atyLlhc4y6cygKDyvYweYQQV/6nSdZpZVsOWuAPjbWEienqOoVWQkgzL+JPeit40EVVuQOrEM2NxLQ/APQfZQaZfznbuazdVZB50BZ/gDwi2tfjgtKYJWX0kNSZEfgsmw78sQ07HuN5EAHloelD7KoqFL4igQg2FxRGjZs8C8AoZhdPL/uukTNpORoq2BqYbf6nqADkzzBn/ozGFCzVVXiP4c+LYXD+R3shGd4Dr49aUNvc3ZhfaMAzzJSgbPYdfzRs7Q3AlirjZKm/pdicos8iRtJaxTdJD0NAgMBAAECggEAJkKERrOlJ+usU3PNwx6nvFaVULvzQ2vve0Ok4nthlnDdJfxXkK+/gqWZIhpsHN8S/WpRcEBhPYn8WiPTeb6nbufOoHtNus+RNRk/2l3BeUMkdg/PBW49rVZvJVwdZtjVW3Xo6JYIIStgwsl9Z0ijDjw2N+lrjF+6Mvq+caz/Zaw2xgcQSwGYLSDsAbD3olG7Ih+jlAk2MJdIMTw/VtAP2f7nPyztmtiVkkM+G/pG5R/p2Kq8jrP0A+AQ4p4sYilYRFnqddRbdDzOOFw80vWe4VdNwOr3Ka/LtOVWGDNQPDuOlL4hQb9qKcWdyIQ4p46ncXoGpfrGRxog61Y7v86VwQKBgQDhfKomivYyKtQM6dJajOl5OpU97UnmbKlgXl+8XticYALWR2QbtbV4MQPNYXGyAB2wI1GHrIETJcwSXtLKbKYvsrBCHXdhKmDUvW3mX0tnAWi+z2SGbjwCIVxmoSKXdZdfp6qqACd6mEq27x0+s48/FWfryTU7NgzKpOtTn1ILkQKBgQC7RfmdiTynN9GmOR3HJvvL1rWTa2b6qxaHWZswhCbxxfc0hvPacPaGwPtryVlMd9PZGc6im3rHBX3Y3FwXUUrJ/BEcLi4Y8zaVLhGAHcDuzCa0de1/FhP8qpSCobK6lHeeqESoEXQmWn1S7pH4rYRyuOvVR6vi4YNFHZD/ov8DvQKBgDjpOxTBTAQ7dQvRVCtQl3jmhVZ89oL2+AT/rNAhbDCDtxOYLzcjNKsiS+BhcM3JY7TaJTDGJEnN52TXlAJNS+CMDBqTz1ax2IC5UuyrLp/P5j0KoUeguPqcqvKoRs/NeShGbDe+FDjICUuErG/v5/63C2SigxHvwWjAGTkg5BdRAoGBAIRWZpaUrG/eWiCErC5XtgfNqnKKqzLoQ/tRrwER4hNoOdC8rQXoXc3MAd+hYaFP7Dy2p/bwuEp77vqYfdtcbuVdYxnu6FRpSmERNPy8CeK2EYPk8fekumsKf/fwHEUNNZrAfgPmkZWozHcWb8Czna0UUFNfWm/xvLnSsuxzWpJhAoGAUqzQWQ3q26kLMaLdaMzu+iYtP+YpasWzynpYM03NEXbl5QZXHzm3STygDqPJVLI4TXlWLkSBOgeIa5mPCytDIur+WBd6z4Ix1cWLVCob9ZPsLqDgV16Q90uSlsXFmMO7BSGgb2U+oJXvdwjcRTeaJHeOwglm+a1hIzKPweCXK/M=";

    @Test
    public void testGetPaymentOrderEncrypted() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            PaymentService paymentService = client.getPaymentService();

            PaymentOrderEncryptedRequest request = new PaymentOrderEncryptedRequest();
            request.setSubject("算是个+东西&");  // 商品简介（含特殊字符&）
            request.setGameArea("1服 华南");    // 游戏区服名称（含空格）
            request.setGameLevel("2710");      // 角色等级
            request.setGameOrderId("X7O16691572509291647576329"); // 游戏方订单号
            request.setGameCurrency("CNY");    // 货币类型（人民币）
            request.setGamePrice("100.00");    // 商品价格（保留两位小数）
            request.setGameRoleId("0777");     // 角色ID
            request.setGameRoleName("想了很久u&me"); // 角色名称（含特殊字符&）
            request.setGameGuid(71268837);     // 用户游戏小号唯一标识
            request.setNotifyId("-1");         // 支付回调通知ID（默认-1）
            request.setGameAccessVersion("6.106"); // 接入签名版本

            String extendsData = "{\"name\":\"南极&赤道\"}"; // JSON中的Unicode已转义
            request.setExtendsInfoData(extendsData);
            PaymentOrderEncryptedResponse paymentOrderEncrypted = paymentService.getPaymentOrderEncrypted(request);
            System.out.println(paymentOrderEncrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPaymentOrderCallbackVerify() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            PaymentService paymentService = client.getPaymentService();

            PaymentOrderCallbackVerifyRequest request = new PaymentOrderCallbackVerifyRequest();
            // 必填字段（根据回调数据）
            request.setXiao7Goid(93761820);                      // 小7订单ID（Integer）
            request.setSubject("算是个+东西&");                   // 商品简介（含特殊字符&）
            request.setGameOrderId("X7O16691572509291647576329"); // 游戏订单号
            request.setGameArea("1服 华南");                      // 游戏区服（含空格和中文）
            request.setGameRoleId("0777");                       // 角色ID
            request.setGameRoleName("想了很久u&me");              // 角色名称（含特殊字符&）
            request.setGameLevel("2710");                        // 角色等级
            request.setExtendsInfoData("{\"name\":\"南极&赤道\"}"); // JSON扩展数据（需转义双引号）
            request.setSdkVersion("6.0");                        // SDK版本
            request.setCouponPrice(0.00);                       // 代金券金额（Float）
            request.setEncrypData("XlLaBXOlOzzdLFbN8PKRAv7L1i03PWd3tdEwuzviqr2QHD8caa9KmroCqQJnH98PvoFK6dysAqD0xUtJNjMnPMu6f+DqbMikp7edNbZqpzb0iui87Dr/EliS6o2OlSBLgSuro9IW0Jx8RWbT3K3+6ybJgz++qcRZbjy1xn22Ur0="); // RSA加密数据
            request.setSignData("LAUn8gEIMSlCePjY7X+ZFD5Hu4zs03OwUkNv+wXUttbvy0WcFWFs57GMiXoq5xCttSJNocpgt4uJwQssK+zih9VY5b7pQeSjP2PbvXyGBKHkd0m3Wcdse6ZPbuksvXsxA4Y49pPGr4cGHOp8EQDHPmEkHt3rURRNZ5a65LfmZPM="); // 签名数据

            PaymentOrderCallbackVerifyResponse paymentOrderCallbackVerify = paymentService.getPaymentOrderCallbackVerify(
                    request);
            System.out.println(paymentOrderCallbackVerify);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
