package com.web.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @author lhj
 * @date 2019/11/29 16:48
 */
@RestController
public class TestController {




    @GetMapping("/getFile")
    public String getFile(){
        String resource = TestController.class.getResource("/image/20170805140022629.png").getPath();
        System.out.println("=================="+resource);
        File file = new File(resource);
        return file.getName();
    }



    @GetMapping("/getAli")
    public String testAli() {
        String appCertPublicKey = "/usr/local/src/spring-boot/cert/appCertPublicKey_2019091967595220.crt";
        String alipayCertPublicKey_RSA2 = "/usr/local/src/spring-boot/cert/alipayCertPublicKey_RSA2.crt";
        String alipayRootCert = "/usr/local/src/spring-boot/cert/alipayRootCert.crt";
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        certAlipayRequest.setServerUrl("https://openapi.alipay.com/gateway.do");
        certAlipayRequest.setAppId("2019091967595220");
        certAlipayRequest.setPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCnTHkKN0T7BCtKRHn5wH998Ye3RbHOdFmcqO9sqI7aADqT7Gq1ZLjLubDk+yIdMRyRuKx9WhrNy7u2gtPxoFscU36ZG+QBlSR6MJcCO/kiy8J3EJxprGyDX5mq4B1ggQfbnchzGYSt9Kp8BHvumm3QhDXFbLKSJwKUCKyFsixskFAiTkX36RSqTFWSahKH1XP9RHcnB4ioC8SQ4mSc5g5Lwon4vWv8aQ7EHslwZztpgi+3b8tDKoohfD0WV3MzvOlEyFHdEtRB/xTnJaRdWRIEkl+qD0IT+71ysXbfNrGVeXbMjEOsQLSxYAajT0PbXaozY2L/VDIidDSvrS/facQFAgMBAAECggEAWp6etbzoXXuNo2XiGDmAFY098TUMMgNuAuCzB81py4XyNOwLhQPw4VFNE0tA2EUg74Hz1NZ4zF596EeHXEt67qX/XhnwcDcEEje9pFUuBv4N8QaLYuYlxSeEij1pTDu4MOqPiGEbMErmCdU3+C+oKhljMvRE6cu9psfoA2dWjtrggTJsVOXr1nnW/ZfMNpRHAV2DFJS9Xy/GsztlfgR/0T8dGulYyeU2s8RI7PgcW/mkg0g/IwsayWAK7j8JOxZnM1w85ePTaVNqZeO0gt2IQM6nlgnDivVPf3w3Lb/wwcmkpWSJaz6viXWpdqpv3pvj7lVo4P0kNhPxQBSCg52mIQKBgQDSrk5LI09O62ms1F2wuJ9glxdL7ZPgbjYsGRdCZ18i+3DyydaNakm3FQSLJPLSrEFrgSFX2cH3cVGn4fc1SkXRb/VGfE3X30BZxTcFbFi9tCSbynKI3xjdkYqI3GUQxLNYO1wrqvTgtijHsGhxs/t72LsULs87U8CEEnQCse4mvQKBgQDLSTb8LxTHyJvYqqw0Pp/6rke7kYxkj6vin5mg/bBMv/A3/7MSU2WkkMzNM995uL7teDEytVYZM0PQRYv0T5Fenu/nI7KQy/RV+ZyuZhCVSX3zuUuN3h5uR1c2g/B7f4T17EvYSTyxV/QxtqLXe5f11+sR9DzXOhCvyOBImhuq6QKBgCO7MkYmD+5XmM2aGuW8+jLcjTPwcDMRHhjujHZTp9v7/xT+TGghja0CYInk01YNpu6/sNMAeJgp3Op3NYERPrQdo+C3dlBVacmP3BwMWySZZ9gQRsqV49a4N2Gs12s3oR8muiQh03RFELeFYMFgABfqExiCM91g//amVoyadsSVAoGAR4m5Xt/WqUPQjFvrg+sx807XkYtz44On0nWl48DDBQ9aoupKAz3z/Ai0+dWyZCx+jCUK8zRbWzzuNWH0EYLavniiJi4qzcfocUUJPVpPpamaOGXRz9gFz3stltKxk1RZ3w1L145WXHZ+SexivAAThwF4CPZxXrBhZOsE+qe46tkCgYEAqrq4JAngPOAtNdTMr4/DpC0UEdiF+lTJSzEBW3u0ka8EJkMWf1FLK2iMh6J6I7fHq+cXDDSQH1xuFE0J3le3XAC8ImWGxM5/A0B3NhHJzxwul/SmMXoq6wpA2VkE2WFBuYfxxJwnez3SArI9mD3WQrEJ11hdqlJPDMXX2P8qVcQ=");
        certAlipayRequest.setFormat("JSON");
        certAlipayRequest.setCharset("GBK");
        certAlipayRequest.setSignType("RSA2");
        certAlipayRequest.setCertPath(appCertPublicKey);
        certAlipayRequest.setAlipayPublicCertPath(alipayCertPublicKey_RSA2);
        certAlipayRequest.setRootCertPath(alipayRootCert);
        System.out.println("=================="+appCertPublicKey);
        File file = new File(appCertPublicKey);
        System.out.println("文件是否存在："+ file.exists());
        System.out.println(file.getName());
        System.out.println("=================="+alipayCertPublicKey_RSA2);
        File file2 = new File(alipayCertPublicKey_RSA2);
        System.out.println(file2.getName());
        System.out.println("=================="+alipayRootCert);
        File file3 = new File(alipayRootCert);
        System.out.println(file3.getName());
        try {
            DefaultAlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
        } catch (AlipayApiException e) {
            System.out.println(e);
        }

        return file.getName();

    }

}
