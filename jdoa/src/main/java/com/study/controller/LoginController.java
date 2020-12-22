package com.study.controller;

import com.study.config.MyResult;
import com.study.pojo.Emp;
import com.study.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: pengjia
 * @date: 2020/12/21
 * @description:
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService empService;

    @PostMapping("/login")
    public MyResult login(@RequestBody Emp emp) {
        return empService.login(emp);
    }
}
