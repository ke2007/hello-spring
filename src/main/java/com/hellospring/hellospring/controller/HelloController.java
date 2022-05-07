package com.hellospring.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")

    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); // value 부분이 templetes폴더의 hello.html의  ${data}에 들어가게됨. 값은 db에서 조회해서 바꿀수도있다!
        return "hello"; //templetes폴더의 hello.html에 넘어가서 실행해라 이때 넘기는 데이터 model(data:hello!!) 다
    }
}
//스프링부트가 알아서 templetes폴더 {파일이름 ex) hello }.html 로 뷰 매핑