package com.itheima.controller;

import com.itheima.pojo.Result;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {

        //获取原始文件名
        String originalFilename=image.getOriginalFilename();
        //构建新的文件名
        String newfileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //将文件保存在服务器端 在xx 目录下
//        String filePath ="..\\src\\main\\resources\\file\\";
        String filePath = "D:\\C盘挪的文件夹勿删\\桌面\\工作学习\\学习\\JAVA\\File类学习\\springboot\\file\\";
        image.transferTo(new File(filePath+newfileName));
        return Result.success();
    }
}
