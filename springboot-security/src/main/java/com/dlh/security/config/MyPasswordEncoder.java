package com.dlh.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author wutao
 * @date 2018/11/7
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
