package com.metacoding.authblog._core.config;

import com.metacoding.authblog.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http, HttpSession httpSession) throws Exception {

        // csrf 규칙을 안지키면 막힘 >> 해제시켜야함
        http.csrf(c -> c.disable()); // 전체 해제

        http.authorizeHttpRequests(r ->
                        r.requestMatchers("/s/**").authenticated().anyRequest().permitAll())
                .formLogin(f ->
                        f.loginPage("/login-form")
                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/")
                                .successHandler((request, response, authentication) -> {
                                    User user = (User) authentication.getPrincipal();
                                    HttpSession session = request.getSession();
                                    session.setAttribute("sessionUser", user);
                                    response.sendRedirect("/");
                                }));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
