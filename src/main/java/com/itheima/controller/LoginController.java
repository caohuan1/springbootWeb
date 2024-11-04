package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    EmpService empService;

    //登录功能
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        emp =empService.login(emp);
        return emp != null ? Result.success() : Result.error("用户名或密码错误");
    }
}
