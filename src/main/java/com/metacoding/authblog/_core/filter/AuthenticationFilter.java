package com.metacoding.authblog._core.filter;

import com.metacoding.authblog.user.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("실행중?");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser == null) {
            resp.sendRedirect("/login-form");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
