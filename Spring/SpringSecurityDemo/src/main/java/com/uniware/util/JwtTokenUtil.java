package com.uniware.util;

import com.uniware.bean.User;
import com.uniware.exception.TokenException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultJwsHeader;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtTokenUtil
 * @Description TODO
 * @Author Å®ÓÑGakki
 * @Date 2019/9/20 21:56
 */
@Component
@Getter
public class JwtTokenUtil {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    @Value("${jwt.rememberExpiration}")
    private int rememberExpiration;


    public String encode(String body){
        return Jwts.builder().setSubject(body).signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(new Date(System.currentTimeMillis() + rememberExpiration)).compact();
    }

    public String decode(String str) throws Exception{
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(str).getBody().getSubject();
    }




    public static void main(String[] args) throws Exception {
        JwtTokenUtil util = new JwtTokenUtil();
        String res = Jwts.builder().setSubject("123").signWith(SignatureAlgorithm.HS512, "nvyougakki")
                .setExpiration(new Date(System.currentTimeMillis() - 120000)).compact();
        System.out.println(res);
        Jwts.parser().setSigningKey("nvyougakki").parseClaimsJws("123");
        //util.decode("123");

    }

}

