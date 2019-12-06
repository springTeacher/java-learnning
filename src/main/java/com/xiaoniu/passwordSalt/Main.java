package com.xiaoniu.passwordSalt;

import java.util.UUID;

/**
 * @author lhj
 * @date 2019/12/6 10:23
 */
public class Main {


    public static void main(String[] args) {
        // write your code here
        String salt = UUID.randomUUID().toString();
        PasswordEncryptor encoderMd5 = new PasswordEncryptor(salt, "sha-256");
        String encodedPassword = encoderMd5.encode("xiaochangwei's password");
        System.out.println("加密后密码：" + encodedPassword + "\n密码长度：" + encodedPassword.length());
        System.out.println("salt:" + salt);

        boolean isvalid = encoderMd5.isPasswordValid(encodedPassword, "xiaochangwei's password");

        System.out.println("加密后密码：" + isvalid);
    }
}
