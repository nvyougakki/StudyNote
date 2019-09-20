package com.uniware.config;

import com.uniware.util.AESCode;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName NvyougakkiPasswordEncoder
 * @Description TODO
 * @Author heyu
 * @Date 2019/9/20 16:03
 */
public class NvyougakkiPasswordEncoder implements PasswordEncoder {

    private final String password_encode_key = "nvyougakkipasswd";


    @Override
    public String encode(CharSequence rawPassword) {
        return AESCode.encrypt((String) rawPassword, password_encode_key);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return AESCode.encrypt((String)rawPassword).equals(encodedPassword);
    }
}
