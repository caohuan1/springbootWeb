package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    EmpService empService;

    //登录功能
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        emp =empService.login(emp);
        if(emp != null ){
            HashMap<String, Object> c =new HashMap<>();
            c.put("id",emp.getId());c.put("name",emp.getName());c.put("username",emp.getUsername());
            String jwt = JwtUtils.generateJwt(c);
            return Result.success(jwt);
        }
        return  Result.error("用户名或密码错误");
    }
}
