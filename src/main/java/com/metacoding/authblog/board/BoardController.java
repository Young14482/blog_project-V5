package com.metacoding.authblog.board;

import com.metacoding.authblog.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final HttpSession session;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user) {
        //@AuthenticationPrincipal >> 세션의 userDetails를 가져옴 >> 지금 userDetails를 User클래스로 만들어놔서 바로 클래스로 가져와짐
        System.out.println(user.getUsername() + " 로그인됨");
        return "index";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }
}
