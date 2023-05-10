package com.app.security.controller;

import com.app.security.provider.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
@Slf4j
public class BoardController {
    @GetMapping("/list")
    public void list(@AuthenticationPrincipal UserDetail userDetail){
        log.info("==============: " + userDetail.getMemberId());
    }
}
