package com.itheima.security.springmvc.interceptor;

import com.itheima.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KRY);
        if (object == null) {
            writeContent(response, "请登录");
        }
        UserDto user = (UserDto) object;
        //請求的URL
        String requestURI = request.getRequestURI();
        if (user.getAuthorities().contains("p1") && requestURI.contains("/r1")) {
            return true;
        }

        if(user.getAuthorities().contains("p2")&&requestURI.contains("/r2")){
            return  true;
        }

        writeContent(response,"權限不足");
        return false;
    }

    //响应输出
    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf‐8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
        response.resetBuffer();
    }

}
