package com.itheima.controller;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工管理Controller
 */
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

//    @GetMapping     //接收前端两个参数。  参数一：第几页  参数二：每页展示多少行
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10")Integer pageSize){
//        PageBean pageBean =empService.page(page,pageSize);
//        return Result.success(pageBean);
//    }

    //使用PageHelper实现上面的功能（具体实现见service层）
    @GetMapping     //接收前端两个参数。  参数一：第几页  参数二：每页展示多少行
    public Result pageHelper(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10")Integer pageSize){
        PageBean pageBean =empService.pageHelper(page,pageSize);
        return Result.success(pageBean);
    }
}
