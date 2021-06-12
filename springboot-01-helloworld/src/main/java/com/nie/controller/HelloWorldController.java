package com.nie.controller;

import com.nie.pojo.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.nie.utils.GreetingUtils.getGreeting;

@RestController
public class HelloWorldController {

    // 路径变量方式传递参数 e.g. /hello/张三/博士
    @RequestMapping("/hello/{name}/{title}")
    public String helloSomeone(@PathVariable("name") String name, @PathVariable("title") String title){
        return getGreeting(name, title);
    }

    // 最朴素直接的方式 e.g. /hello1?name=张三&title=博士 注意，仅Get有效！
    @GetMapping("/hello1")
    public String helloSomebody(String name, String title){
        return getGreeting(name, title);
    }

    // 通过HttpServletRequest 获取, Get和Post(仅form提交)均可 e.g. /hello2?name=张三&title=博士
    @RequestMapping("/hello2")
    public String helloOtherOne(HttpServletRequest request){
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        return getGreeting(name, title);
    }

    // 通过bean封装成对象来获取, Get和Post(仅form提交)均可 e.g. /hello3?name=张三&title=博士
    @RequestMapping("/hello3")
    public String helloPerson(Person person){
        return getGreeting(person);
    }

    // @RequestParam的使用, 仅Get有效 e.g. /hello3?name=张三&title=博士
    @GetMapping("/hello4")
    public String helloFourthOne(@RequestParam("name") String name, @RequestParam("title") String title){
        return getGreeting(name, title);
    }

    // @RequestBody的使用, 仅Post有效, 前端需要提交json格式（表单提交会报415错误）
    @PostMapping("/hello5")
    public String helloFifthOne(@RequestBody Person person){
        return getGreeting(person);
    }

}
