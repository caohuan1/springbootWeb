package com.itheima.service;

import com.itheima.pojo.PageBean;

/**
 * 员工管理
 */
public interface EmpService {

    PageBean page(Integer page, Integer pageSize);

    //使用PageHelper实现分页查询
    PageBean pageHelper(Integer page, Integer pageSize);
}
