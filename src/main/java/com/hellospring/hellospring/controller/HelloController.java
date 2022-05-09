package com.hellospring.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.Name;
import javax.xml.transform.Templates;

@Controller
public class HelloController {

    @GetMapping("hello")

    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); // value 부분이 templetes폴더의 hello.html의  ${data}에 들어가게됨. 값은 db에서 조회해서 바꿀수도있다!
        return "hello"; //templetes폴더의 hello.html에 넘어가서 실행해라 이때 넘기는 데이터 model(data:hello!!) 다
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-Template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String hellostring(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody // 웹브라우저에서 hello-api를 던진다, 근데 responsebody가 있네? "그대로 이 데이터를 넘겨야겠다 " 근데 객체가 넘어가네? -> 스프링 : 아 , 객체가 오면 Json방식으로 데이터를 만들어서 데이터를 반환해야겠다. viewresolver대신에 Httpmassageconverter가 작동한다, 객체가 넘어오면 Jsonconverter가 객체를 json스타일로 바꾼걸 요청한 서버나 웹브라우저에 보내준다.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        private String Name;


    }


}
//스프링부트가 알아서 templetes폴더 {파일이름 ex) hello }.html 로 뷰 매핑
