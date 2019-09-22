package com.uniware.system;

import com.uniware.dao.repository.UserRepository;
import com.uniware.exception.TokenException;
import com.uniware.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/9/22 18:40
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private TokenService tokenService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(jwtTokenUtil.getTokenHeader());
        String authToken = request.getHeader(jwtTokenUtil.getTokenHeader());

        if(StringUtils.isEmpty(authToken)){
            response.setStatus(403);
            throw new TokenException("用户未登录");
        }
        try{
            String res = tokenService.validateToken(token);
            if(StringUtils.isEmpty(res)){
                throw new TokenException("无效的token");
            }
        } catch (Exception e) {
            response.setStatus(403);
            throw e;
        }


        //验证token是否合法
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
