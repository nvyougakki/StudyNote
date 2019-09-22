package com.uniware.system;

import com.uniware.exception.TokenException;
import com.uniware.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName TokenService
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/9/22 18:44
 */
@Service
public class TokenService {

    @Autowired
    JwtTokenUtil tokenUtil;

    public String validateToken(String token){
        try{
            return tokenUtil.decode(token);
        } catch (ExpiredJwtException e){
            throw new TokenException("token过期");
        } catch (MalformedJwtException e) {
            throw new TokenException("token无效");
        } catch (Exception e) {
            throw new TokenException("验证token出错");
        }
    }


    //
    //

}
