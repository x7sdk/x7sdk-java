package com.x7.sdk.client;

import com.x7.sdk.service.PaymentService;
import com.x7.sdk.service.UserService;
import com.x7.sdk.service.impl.GameInfoServiceImpl;
import com.x7.sdk.service.impl.PaymentServiceImpl;
import com.x7.sdk.service.impl.UserServiceImpl;
import com.x7.sdk.service.impl.X7MallServiceImpl;

public class X7Client {

    /**
     * 小7平台公钥，用于验证小7SDK传递过来的数据签名是否合法。
     */
    private final String x7PublicKey;

    /**
     * 游戏私钥，用于对游戏传递给小7SDK的数据进行签名。
     */
    private final String gamePrivateKey;


    private final UserService userService;
    private final PaymentService paymentService;
    private final GameInfoServiceImpl gameInfoService;
    private final X7MallServiceImpl x7MallService;

    public X7Client(String x7PublicKey, String gamePrivateKey) {
        this.x7PublicKey = x7PublicKey;
        this.gamePrivateKey = gamePrivateKey;
        this.paymentService = new PaymentServiceImpl(x7PublicKey);
        this.userService = new UserServiceImpl(x7PublicKey);
        this.gameInfoService = new GameInfoServiceImpl(gamePrivateKey, x7PublicKey);
        this.x7MallService = new X7MallServiceImpl(gamePrivateKey, x7PublicKey);
    }

    public UserService getUserService() {
        return userService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public GameInfoServiceImpl getGameInfoService() {
        return gameInfoService;
    }

    public X7MallServiceImpl getX7MallService() {
        return x7MallService;
    }
}
