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
    @ResponseBody
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
