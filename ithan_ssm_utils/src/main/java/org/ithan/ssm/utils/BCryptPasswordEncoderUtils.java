package org.ithan.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author HanMengJie
 * @Date 2020/5/12 19:52
 **/
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encoderPassWord(String pwd){
        return bCryptPasswordEncoder.encode(pwd);
    }

    public static void main(String[] args) {
        System.out.println(BCryptPasswordEncoderUtils.encoderPassWord("123"));
    }


}
