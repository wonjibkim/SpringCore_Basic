package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // 아무것도 링크를 걸지 않으면 index 페이지로 가지만 우선순위가 있어서 controller에서 찾고 없으면 index페이지를 반환
    public String home(){
        return "home";
    }

}
