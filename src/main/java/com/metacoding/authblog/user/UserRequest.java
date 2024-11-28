package com.metacoding.authblog.user;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRequest {

    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }

    @Data
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;

        public User toEntity(PasswordEncoder passwordEncoder) {
            String encPassword = passwordEncoder.encode(password);
            System.out.println(encPassword);
            User user = new User(null, username, encPassword, email, null);
            return user;
        }
    }

}
