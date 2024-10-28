package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    List<Dept> list();

    int delete(Integer id);

    void add(Dept dept);

    Dept select(int id);

    int update(Dept dept);
}
