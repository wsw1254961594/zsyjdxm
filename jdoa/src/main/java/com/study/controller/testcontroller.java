package com.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class testcontroller {
    @RequestMapping("a")
    public String test(){
        return "111";
    }
}
