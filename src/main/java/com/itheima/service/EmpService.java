package com.itheima.service;

import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {

    PageBean page(Integer page, Integer pageSize);

    //使用PageHelper实现分页查询
    PageBean pageHelper(Integer page, Integer pageSize,String name, Short gender,
                        LocalDate begin,
                        LocalDate end);

    int deleteById(List<Integer> ids);
}
