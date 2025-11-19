package x7Mall;

import com.x7.sdk.client.X7Client;
import com.x7.sdk.model.GameRoleInfo;
import com.x7.sdk.model.IssuedProp;
import com.x7.sdk.model.request.GetGameRoleReportSignRequest;
import com.x7.sdk.model.request.GetMallEntranceEncryptionRequest;
import com.x7.sdk.model.request.GetMallIssuedPropsEncryption;
import com.x7.sdk.model.request.GetMallOrderNotifyEncryptionRequest;
import com.x7.sdk.model.request.GetMallQueryPropsEncryption;
import com.x7.sdk.model.request.GetMallRoleEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.GetGameRoleReportSignResponse;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;
import com.x7.sdk.service.impl.GameInfoServiceImpl;
import com.x7.sdk.service.impl.X7MallServiceImpl;
import com.x7.sdk.util.X7RSAUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class X7MallServiceTest {

    private String x7PublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBRKkJsJftrclIfT+2ueH3tkIa+BboTeeihEtL+1nLKdceSK2rQWjwru8Kbb9UuZgoJozD6/75cOhKuxlYWu347nkXx/GuYNqVjUXE1QYbI74KbAhcJCMGEsC8dPBs15vFrxEawKV63iHIBmGceM+vM+8JrnP0C7DVT0Z+c/g9gwIDAQAB";
    private String gamePrivate = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCk87LBB7pFXX0QOFY1MN7BeYkf71xt/e1LAwz8jVSwvK37V+K2x9atyLlhc4y6cygKDyvYweYQQV/6nSdZpZVsOWuAPjbWEienqOoVWQkgzL+JPeit40EVVuQOrEM2NxLQ/APQfZQaZfznbuazdVZB50BZ/gDwi2tfjgtKYJWX0kNSZEfgsmw78sQ07HuN5EAHloelD7KoqFL4igQg2FxRGjZs8C8AoZhdPL/uukTNpORoq2BqYbf6nqADkzzBn/ozGFCzVVXiP4c+LYXD+R3shGd4Dr49aUNvc3ZhfaMAzzJSgbPYdfzRs7Q3AlirjZKm/pdicos8iRtJaxTdJD0NAgMBAAECggEAJkKERrOlJ+usU3PNwx6nvFaVULvzQ2vve0Ok4nthlnDdJfxXkK+/gqWZIhpsHN8S/WpRcEBhPYn8WiPTeb6nbufOoHtNus+RNRk/2l3BeUMkdg/PBW49rVZvJVwdZtjVW3Xo6JYIIStgwsl9Z0ijDjw2N+lrjF+6Mvq+caz/Zaw2xgcQSwGYLSDsAbD3olG7Ih+jlAk2MJdIMTw/VtAP2f7nPyztmtiVkkM+G/pG5R/p2Kq8jrP0A+AQ4p4sYilYRFnqddRbdDzOOFw80vWe4VdNwOr3Ka/LtOVWGDNQPDuOlL4hQb9qKcWdyIQ4p46ncXoGpfrGRxog61Y7v86VwQKBgQDhfKomivYyKtQM6dJajOl5OpU97UnmbKlgXl+8XticYALWR2QbtbV4MQPNYXGyAB2wI1GHrIETJcwSXtLKbKYvsrBCHXdhKmDUvW3mX0tnAWi+z2SGbjwCIVxmoSKXdZdfp6qqACd6mEq27x0+s48/FWfryTU7NgzKpOtTn1ILkQKBgQC7RfmdiTynN9GmOR3HJvvL1rWTa2b6qxaHWZswhCbxxfc0hvPacPaGwPtryVlMd9PZGc6im3rHBX3Y3FwXUUrJ/BEcLi4Y8zaVLhGAHcDuzCa0de1/FhP8qpSCobK6lHeeqESoEXQmWn1S7pH4rYRyuOvVR6vi4YNFHZD/ov8DvQKBgDjpOxTBTAQ7dQvRVCtQl3jmhVZ89oL2+AT/rNAhbDCDtxOYLzcjNKsiS+BhcM3JY7TaJTDGJEnN52TXlAJNS+CMDBqTz1ax2IC5UuyrLp/P5j0KoUeguPqcqvKoRs/NeShGbDe+FDjICUuErG/v5/63C2SigxHvwWjAGTkg5BdRAoGBAIRWZpaUrG/eWiCErC5XtgfNqnKKqzLoQ/tRrwER4hNoOdC8rQXoXc3MAd+hYaFP7Dy2p/bwuEp77vqYfdtcbuVdYxnu6FRpSmERNPy8CeK2EYPk8fekumsKf/fwHEUNNZrAfgPmkZWozHcWb8Czna0UUFNfWm/xvLnSsuxzWpJhAoGAUqzQWQ3q26kLMaLdaMzu+iYtP+YpasWzynpYM03NEXbl5QZXHzm3STygDqPJVLI4TXlWLkSBOgeIa5mPCytDIur+WBd6z4Ix1cWLVCob9ZPsLqDgV16Q90uSlsXFmMO7BSGgb2U+oJXvdwjcRTeaJHeOwglm+a1hIzKPweCXK/M=";

    @Test
    public void testGetMallEntranceEncryption() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            X7MallServiceImpl x7MallService = client.getX7MallService();
            GetMallEntranceEncryptionRequest request = new GetMallEntranceEncryptionRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime("2025-09-02T17:21:25+0800");
            request.setOsType("android");

            // 设置角色信息
            GameRoleInfo roleInfo = new GameRoleInfo();
            roleInfo.setRoleId("R123456789");
            roleInfo.setRoleName("测试02");
            roleInfo.setRoleLevel("10");
            roleInfo.setServerId("1");
            roleInfo.setServerName("测试");
            roleInfo.setRoleRechargeAmount(0.0);
            roleInfo.setRoleGuild("1");
            roleInfo.setRoleCE("1");
            roleInfo.setRoleStage("1");
            roleInfo.setGuid("71272083");
            request.setRole(roleInfo);

            MethodCommonReqResponse response = x7MallService.getMallEntranceEncryption(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckMallEntranceResp() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            X7MallServiceImpl x7MallService = client.getX7MallService();
            MethodCommonRespVerifyRequestBO verifyRequestBO = new MethodCommonRespVerifyRequestBO();
            verifyRequestBO.setApiMethod("x7mall.mallEntry");
            verifyRequestBO.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            verifyRequestBO.setRespTime("2025-11-03T17:11:50+0800");
            verifyRequestBO.setGameType("client");
            verifyRequestBO.setSignature("Nwrc+nxfjMrc8m3mYwGRjOwbfKTCpSf1Mg3xowRMC911PJplv9RUomNDhm09xVzWiMeDRkUZNoUJarWazeNue9o+UxFmA3XLv+kZoEls5MHi5JrxNcyFJWoZOdrkaTxDlF/DFGkyJ8iKRKFvZiB4E7ODv+TRmrfZ8Nd0kJN1sqM=");
            verifyRequestBO.setBizResp("{\"isOpen\":false,\"showNotification\":false,\"respCode\":\"SUCCESS\",\"respMsg\":\"\"}");
            SignatureVerifyCommonResponse response = x7MallService.checkMallEntranceResp(
                    verifyRequestBO);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMallRoleEncryption() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            X7MallServiceImpl x7MallService = client.getX7MallService();
            GetMallRoleEncryptionRequest request = new GetMallRoleEncryptionRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime("2025-11-03T17:30:00+0800");
            request.setOsType("ios");
            request.setRoleId("71272083121");
            request.setGuid("71272083");

            MethodCommonReqResponse response = x7MallService.getMallRoleEncryption(request);
            System.out.println("商城角色加密串响应: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckMallRoleResp() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            X7MallServiceImpl x7MallService = client.getX7MallService();
            MethodCommonRespVerifyRequestBO verifyRequestBO = new MethodCommonRespVerifyRequestBO();
            verifyRequestBO.setApiMethod("x7mall.roleQuery");
            verifyRequestBO.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            verifyRequestBO.setRespTime("2025-11-03T17:29:53+0800");
            verifyRequestBO.setGameType("client");
            verifyRequestBO.setSignature("Iv1ZB2jWGKvhY8IGe/cIuRFOyqq2d8IKOhPMRbxboKzHoRohsbXI5ZR5DQkVGIlAh+X2SXQs19qdwUvsdtqaBGUN/++faY6GrjeloSVEE/lJw0NYtR/D+G+QuSrWhog3+x2tI0EEnYMxL3XwhDlHfrGi6S3fEDb0rt31udrDJcs=");
            verifyRequestBO.setBizResp("{\"guidRoles\":[{\"roleId\":\"71272083121\",\"guid\":\"71272083\",\"roleName\":\"测试02\",\"serverId\":\"02\",\"serverName\":\"测试03\",\"roleLevel\":\"4\",\"roleCE\":\"2000\",\"roleStage\":\"3\",\"roleRechargeAmount\":\"0.00\"}],\"role\":{\"roleId\":\"71272083121\",\"guid\":\"71272083\",\"roleName\":\"测试02\",\"serverId\":\"02\",\"serverName\":\"测试03\",\"roleLevel\":\"4\",\"roleCE\":\"2000\",\"roleStage\":\"3\",\"roleRechargeAmount\":\"0.00\"},\"respCode\":\"SUCCESS\",\"respMsg\":\"\"}");

            SignatureVerifyCommonResponse response = x7MallService.checkMallRoleResp(verifyRequestBO);
            System.out.println("商城角色返回值验证结果: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMallOrderNotifyEncryption() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            X7MallServiceImpl x7MallService = client.getX7MallService();
            GetMallOrderNotifyEncryptionRequest request = new GetMallOrderNotifyEncryptionRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime("2025-11-03T18:00:00+0800");
            request.setOsType("android");

            // 订单信息
            request.setOrderId("X7O13632832511031646032981");
            request.setX7Gold("X7S24717022511031646184360");
            request.setGuid("71268837");
            request.setRoleId("R567890123");
            request.setRoleName("订单测试角色");
            request.setServerId("2");
            request.setServerName("测试服2");
            request.setActivityName("双11活动");
            request.setSubject("高级礼包");
            request.setPrice("100.00");
            request.setCouponValue("100.00");
            request.setPayPrice("00.00");
            request.setCreateTime("2025-11-03T17:50:00+0800");
            request.setSuccessTime("2025-11-03T17:55:00+0800");

            MethodCommonReqResponse response = x7MallService.getMallOrderNotifyEncryption(request);
            System.out.println("商城订单通知加密串响应: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckMallOrderNotifyResp() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            X7MallServiceImpl x7MallService = client.getX7MallService();
            MethodCommonRespVerifyRequestBO verifyRequestBO = new MethodCommonRespVerifyRequestBO();
            verifyRequestBO.setApiMethod("x7mall.orderNotify");
            verifyRequestBO.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            verifyRequestBO.setRespTime("2025-11-03T17:38:43+0800");
            verifyRequestBO.setGameType("client");
            verifyRequestBO.setSignature("RFxZV08pldhdWYkIjAeZfKGRfYROY+Rz0QiZL/vS+q+MQZrJVQJ6TVkVxQXh11zX9GmqA2udzvpdMOrX9O/P8J0469UchY3R0I4b41sEdcD0GgwoK2L+eJlk7pstp7iN1P0LdzAHbGjEb+zSGQksLF2xDW+IdxLBrbJ2Zz3Fqp0=");
            verifyRequestBO.setBizResp("{\"respCode\":\"SUCCESS\",\"respMsg\":\"\"}");

            SignatureVerifyCommonResponse response = x7MallService.checkMallOrderNotifyResp(verifyRequestBO);
            System.out.println("商城订单通知返回值验证结果: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMallIssuedPropsEncryption() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            X7MallServiceImpl x7MallService = client.getX7MallService();
            GetMallIssuedPropsEncryption request = new GetMallIssuedPropsEncryption();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime("2025-11-03T18:30:00+0800");
            request.setOsType("android");

            // 发放信息
            request.setIssueOrderId("ISSUE123456");
            request.setRoleId("R112233445");
            request.setGuid("71272086");
            request.setServerId("3");
            request.setServerName("测试服3");
            request.setIssueTime("2025-11-03T18:25:00+0800");
            request.setMailTitle("道具发放通知");
            request.setMailContent("您购买的道具已发放，请注意查收");
            request.setTest(true);

            // 道具列表
            List<IssuedProp> props = new ArrayList<>();
            IssuedProp prop1 = new IssuedProp();
            prop1.setPropCode("P007");
            prop1.setPropName("healing potion");
            prop1.setPropQuantity("10");
            props.add(prop1);
            request.setIssuedProps(props);

            MethodCommonReqResponse response = x7MallService.getMallIssuedPropsEncryption(request);
            System.out.println("商城道具发放加密串响应: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckMallIssuedPropsResp() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            X7MallServiceImpl x7MallService = client.getX7MallService();
            MethodCommonRespVerifyRequestBO verifyRequestBO = new MethodCommonRespVerifyRequestBO();
            verifyRequestBO.setApiMethod("x7mall.propIssue");
            verifyRequestBO.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            verifyRequestBO.setRespTime("2025-11-03T19:40:05+0800");
            verifyRequestBO.setGameType("client");
            verifyRequestBO.setSignature("TiU15eCIoRngOc4OxFe4G86Zo3v6g7KH9Y6WYhaE+sXyg3XGgd56dUGrfGBG4yu58pv5HoCOdTOoNDYNw5XBk4j7SnW8I0nlm0t3AZxhCvxhp+TAVc1ujPqwa4Qwoy1lWb83t9hTTFh6k35DxhP63YOqVY59dUtSueJQOIgCqOY=");
            verifyRequestBO.setBizResp("{\"respCode\":\"SUCCESS\",\"respMsg\":\"发放成功\"}");

            SignatureVerifyCommonResponse response = x7MallService.checkMallIssuedPropsResp(verifyRequestBO);
            System.out.println("商城道具发放返回值验证结果: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMallQueryPropsEncryption() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            X7MallServiceImpl x7MallService = client.getX7MallService();
            GetMallQueryPropsEncryption request = new GetMallQueryPropsEncryption();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setGameType("client");
            request.setReqTime("2025-11-07T19:00:00+0800");
            request.setOsType("android");
            request.setPropCode(Collections.singletonList("1"));

            MethodCommonReqResponse response = x7MallService.getMallQueryPropsEncryption(request);
            System.out.println("商城道具查询加密串响应: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckMallQueryPropsResp() {
        try {
            X7Client client = new X7Client(x7PublicKey, gamePrivate);
            X7MallServiceImpl x7MallService = client.getX7MallService();
            MethodCommonRespVerifyRequestBO verifyRequestBO = new MethodCommonRespVerifyRequestBO();
            verifyRequestBO.setApiMethod("x7mall.propQuery");
            verifyRequestBO.setAppkey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            verifyRequestBO.setRespTime("2025-11-04T15:12:15+0800");
            verifyRequestBO.setGameType("client");
            verifyRequestBO.setSignature("g/QnN0I+vOvOkE4jErQkkAJ9yvcCx7Pc1rxEY7gHri5KOJqmqg7kbtTjc+f5eyMc0PfDhU4oAKeFCEPlBzqH/qR7r+ufiEZLnFije6I+b6yF8yw0RzXOV/IYic0DuePBGJqRXaZKnB82r6b8Irl8RY4x5im1yV2aOi/7sxAsTNw=");
            verifyRequestBO.setBizResp("{\"props\":[{\"propCode\":\"1\",\"propName\":\"任意门\",\"propDesc\":\"只要心中想著想去的地点，电脑就会传达并歪曲所在地与目的地间的空间而将两地靠拢，跨过门就可以到达。但是不能去距离十光年以上的行星，或者是电脑地图上没有的地区。是很常用的道具。\",\"propIcon\":\"https://image1.msshuo.cn/images/x7mall/props/1.jpg\"}],\"respCode\":\"SUCCESS\",\"respMsg\":\"\"}");

            SignatureVerifyCommonResponse response = x7MallService.checkMallQueryPropsResp(verifyRequestBO);
            System.out.println("商城道具查询返回值验证结果: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
