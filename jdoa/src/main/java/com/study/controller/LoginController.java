package com.study.controller;

import com.study.config.MyResult;
import com.study.pojo.Emp;
import com.study.services.EmpServices;
import com.study.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: pengjia
 * @date: 2020/12/21
 * @description:
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private EmpServices empServices;

    @PostMapping("/login")
    public MyResult login(@RequestBody Emp emp) {
        return loginService.login(emp);
    }

    @GetMapping("/emp_detail")
    public MyResult getEmpDetail(Integer empno) {
        return empServices.getEmpDetail(empno);
    }
}
