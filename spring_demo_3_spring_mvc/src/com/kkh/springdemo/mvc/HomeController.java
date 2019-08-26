package com.kkh.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Component를 내포한다
public class HomeController {

    @RequestMapping("/") // WEB-INF/view/main-menu.jsp 와 동일
    public String showPage() {
        return "main-menu";
    }
}
