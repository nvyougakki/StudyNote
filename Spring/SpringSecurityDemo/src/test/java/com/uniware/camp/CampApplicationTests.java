package com.uniware.camp;

import com.uniware.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampApplicationTests {

    @Autowired
    JwtTokenUtil jwtTokenUtil;


    @Test
    public void contextLoads() {
        String token = jwtTokenUtil.encode("194758322");
        Jws<Claims> decode = jwtTokenUtil.decode(token);
        System.out.println(token);
        System.out.println(decode.getBody().get(Claims.SUBJECT));
    }

}
