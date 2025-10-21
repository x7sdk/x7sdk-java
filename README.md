# x7sdk-java SDK 使用文档
## 引入方式

使用maven依赖导入
```xml
<dependency>
    <groupId>io.github.x7sdk</groupId>
    <artifactId>x7sdk-java</artifactId>
    <version>1.0.0</version>
</dependency>
```
## 注意事项
1. 请确保使用的Java版本为Java 8及以上。
2. 请确保网络连接正常，以便能够访问小7的服务端接口。
3. 请妥善保管您的小7公钥和游戏私钥，避免泄露。
4. 请根据实际需求选择需要调用的服务和方法，避免不必要的资源浪费。
5. 请参考小7官方文档，了解各个接口服务端相关参数和流程：https://docs.x7sy.com/#/README
6. 请注意接口调用的频率限制，避免触发小7的防刷机制。
7. 该sdk会引入并使用`commons-codec`、`fastjson`两个第三方库，请确保这些依赖能够正确引入，该两个第三方库已设置为目前稳定版本，如果出现不兼容情况，请及时反馈。


## 使用方法简述
以下示例代码均为简化版，实际使用时请根据具体需求进行调整。
### 客户端初始化
小7java-sdk都是使用初始化的客户端对象，然后获取对应的服务对象来调用接口方法，初始化服务端需要小7公钥合游戏私钥。
```java
// publicKey为小7公钥，privateKey为游戏私钥
X7Client client = new X7Client(publicKey, privateKey);
```
### 登录方法加密并调用
该方法主要是用于校验用户信息时使用，游戏方将小7服务端返回的tokenKey作为传参，调用该方法进行用户登录校验，返回用户的基本信息。
```java
// 初始化客户端并获取用户服务
X7Client client = new X7Client(publicKey, privateKey);
UserService userService = client.getUserService();

// 创建登录请求对象并设置参数
LoginCheckRequest request = new LoginCheckRequest();
request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
request.setTokenKey("e7854780ec04372d64025c1bb29a5560");
LoginCheckResponse response = userService.loginCheck(request);
```
### 用户实名上报信息验签解析
该方法主要用于获取用户实名上报信息，游戏方调用该方法将小7服务器返回的用户实名信息进行验签解析，获取用户实名信息。
```java
// 初始化客户端并获取用户服务
X7Client client = new X7Client(publicKey, privateKey);
UserService userService = client.getUserService();

GetUserRealNameInfoRequest request = new GetUserRealNameInfoRequest();
request.setData("");
GetUserRealNameInfoResponse userRealNameInfo = userService.getUserRealNameInfo(request);
```

### 下单参数加密
该方法主要用于获取支付下单的加密参数，游戏方调用该方法将下单参数进行加密，返回加密后的参数，传给小7支付SDK进行支付。
```java
// 初始化客户端并获取支付服务
 X7Client client = new X7Client(x7PublicKey, gamePrivate);
PaymentService paymentService = client.getPaymentService();
// 创建加密请求对象并设置参数
PaymentOrderEncryptedRequest request = new PaymentOrderEncryptedRequest();
request.setSubject("");  
request.setGameArea("");    
request.setGameLevel("");      
request.setGameOrderId(""); 
request.setGameCurrency("");    
request.setGamePrice("");    
request.setGameRoleId("");     
request.setGameRoleName(""); 
request.setGameGuid(0);     
request.setNotifyId("");        
request.setGameAccessVersion(""); 
String extendsData = ""; 
request.setExtendsInfoData(extendsData);
PaymentOrderEncryptedResponse paymentOrderEncrypted = paymentService.getPaymentOrderEncrypted(request);
```

### 支付回调验签
该方法主要用于支付回调结果的验签，游戏方调用该方法将小7服务器返回的支付回调参数进行验签，获取支付结果。
```java
X7Client client = new X7Client(x7PublicKey, gamePrivate);
PaymentService paymentService = client.getPaymentService();

PaymentOrderCallbackVerifyRequest request = new PaymentOrderCallbackVerifyRequest();
request.setXiao7Goid(0);                      
request.setSubject("");                   
request.setGameOrderId("");  
request.setGameArea("");                      
request.setGameRoleId("");                       
request.setGameRoleName("");              
request.setGameLevel("");                        
request.setExtendsInfoData(""); 
request.setSdkVersion("");                        
request.setCouponPrice(0.00);                       
request.setEncrypData(""); 
request.setSignData("");
PaymentOrderCallbackVerifyResponse paymentOrderCallbackVerify = paymentService.getPaymentOrderCallbackVerify(request);
```
### 角色信息上报加密
该方法主要用于角色信息上报参数加密，游戏方调用该方法将角色信息进行加密，返回加密后的参数，传给小7进行角色信息上报。
```java
 X7Client client = new X7Client(x7PublicKey, gamePrivate);
 GameInfoServiceImpl gameInfoService = client.getGameInfoService();
 GetGameRoleReportSignRequest request = new GetGameRoleReportSignRequest();
 request.setAppKey("");
 request.setGameType("");
 request.setReqTime("");
 GameRoleInfo roleInfo = new GameRoleInfo();
 roleInfo.setRoleId("");
 roleInfo.setRoleName("");
 roleInfo.setRoleLevel("");
 roleInfo.setServerId("");
 roleInfo.setServerName("");
 roleInfo.setRoleRechargeAmount(0.0);
 roleInfo.setServerName("");
 roleInfo.setRoleGuild("");
 roleInfo.setRoleCE("");
 roleInfo.setRoleStage("");
 roleInfo.setGuid("");
 request.setRole(roleInfo);
 GetGameRoleReportSignResponse gameRoleReportSign = gameInfoService.getGameRoleReportSign(request);
```
### 角色信息上报结果验签
该方法主要用于角色信息上报结果的验签，游戏方调用该方法将小7服务器返回的角色信息上报结果进行验签，获取上报结果。
```java
X7Client client = new X7Client(x7PublicKey, gamePrivate);
GameInfoServiceImpl gameInfoService = client.getGameInfoService();

GameRoleReportResultVerifyRequest request = new GameRoleReportResultVerifyRequest();
request.setAppKey("");
request.setGameType("");
request.setReqTime("");
request.setBizResp("");
request.setSignature("");
request.setApiMethod("");
GameRoleReportResultVerifyResponse result = gameInfoService.getGameRoleReportVerifyResult(request);
```
