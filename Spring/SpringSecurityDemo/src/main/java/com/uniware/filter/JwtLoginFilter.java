package com.uniware.filter;

import com.uniware.dao.repository.UserRepository;
import com.uniware.exception.UserNotFoundException;
import com.uniware.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName JwtLoginFilter
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/9/20 21:52
 */
//@WebFilter(urlPatterns = "/*", filterName = "myfilter")
public class JwtLoginFilter {

   /* @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        List<String> permitAll = Arrays.asList(jwtTokenUtil.getPermitAll());

        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        Cookie[] cookies = request1.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(jwtTokenUtil.getTokenHeader())){
                String cookieValue = cookie.getValue();
                //操作未登录
                if(StringUtils.isEmpty(cookieValue)){
                    response1.setStatus(403);
                }
                //判断cookie值是否合法
                String subject = jwtTokenUtil.decode(cookieValue).getBody().getSubject();
                return;
            }
        }
        doFilter(request, response, chain);
    }

    @Override
    public void destroy() {

    }*/
}
