package com.itheima.controller;

import com.itheima.pojo.Result;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image){
        System.out.println("username："+username+"，age："+age+"，image："+image);
        return Result.success();
    }
}
