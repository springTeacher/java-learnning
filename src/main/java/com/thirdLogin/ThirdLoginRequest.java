package com.thirdLogin;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.request.AuthGiteeRequest;
import me.zhyd.oauth.request.AuthQqRequest;
import me.zhyd.oauth.request.AuthRequest;

/**
 * @author lihoujing
 * @date 2019/10/24 14:12
 */
public class ThirdLoginRequest {


    public void login() {
        // 创建授权request
        AuthRequest authRequest = new AuthGiteeRequest(AuthConfig.builder()
                .clientId("clientId")
                .clientSecret("clientSecret")
                .redirectUri("redirectUri")
                .build());
        // 生成授权页面
        String code = authRequest.authorize("state");
        AuthCallback authCallback = new AuthCallback() ;
        authCallback.setCode(code);
        authRequest.login(authCallback);
        // 授权登录后会返回code（auth_code（仅限支付宝））、state，1.8.0版本后，可以用AuthCallback类作为回调接口的参数
        // 注：JustAuth默认保存state的时效为3分钟，3分钟内未使用则会自动清除过期的state
//        authRequest.login(callback);
    }

    public void loginQq(){
        AuthQqRequest authQqRequest = new AuthQqRequest(AuthConfig.builder()
                .clientId("")
                .clientSecret("")
                .redirectUri("")
                .build());
        authQqRequest.authorize();

//        authQqRequest.login()

    }
}
