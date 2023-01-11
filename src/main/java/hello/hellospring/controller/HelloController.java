package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello (Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody// ResponseBody :  http에 헤더와 비디부분으로 나누어져 있는데 바디부분에 응답내용을 직접 넣어준다
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api") //json방식으로 넘기는 법
    @ResponseBody // json이란
    public Hello HelloApi(@RequestParam("name") String name){ //키값 name으로 값을 받음
        Hello hello = new Hello(); // 객체생성
        hello.setName(name);
        return hello;
    }



        static class Hello{
            private String name;

            public void setName(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

    }

