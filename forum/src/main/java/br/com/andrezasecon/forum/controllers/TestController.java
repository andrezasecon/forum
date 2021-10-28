package br.com.andrezasecon.forum.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public String hello(){
        return "Esta funfando, testando devtools, toma no cúuuuu!!!";
    }
}
