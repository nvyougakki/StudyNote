package com.uniware.config;

import com.uniware.util.AESCode;
import org.springframework.stereotype.Component;

/**
 * @ClassName NvyougakkiPasswordEncoder
 * @Description TODO
 * @Author heyu
 * @Date 2019/9/20 16:03
 */
@Component
public class NvyougakkiPasswordEncoder {

    private final String password_encode_key = "nvyougakkipasswd";


    public String encode(CharSequence rawPassword) {
        return AESCode.encrypt((String) rawPassword, password_encode_key);
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return AESCode.encrypt((String)rawPassword).equals(encodedPassword);
    }

    public static void main(String[] args) {
        System.out.println(new NvyougakkiPasswordEncoder().encode("admin"));
    }
}
