package com.thirdLogin.controller;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lihoujing
 * @date 2019/10/24 15:56
 */
@RestController
@RequestMapping("/oauth")
public class ThirdLoginController {



    @RequestMapping("/render/github")
    public void renderAuth(HttpServletResponse response) throws IOException {
        AuthRequest authRequest = getAuthRequest();
        response.sendRedirect(authRequest.authorize());
    }




    private AuthRequest getAuthRequest() {

        return new AuthGithubRequest(AuthConfig.builder()

                .clientId("2c39db25a0ac66326ced")

                .clientSecret("fb93d5622ade3cbc478ddebd932bc0875bd0ebca")
                .redirectUri("")
                .build());

    }
}
