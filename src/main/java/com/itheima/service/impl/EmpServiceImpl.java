package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        //获取总行数
        Integer count = empMapper.count();

        //获取数据列表
        Integer start = (page-1)*pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);

        //封装为PageBean对象
        PageBean pageBean =new PageBean(count,empList);

        return pageBean;
    }

    @Override//使用PageHelper实现分页查询
    public PageBean pageHelper(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<Emp> empList = empMapper.pageHelper(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>) empList;
        //封装为PageBean对象
        PageBean pageBean =new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public int deleteById(List<Integer> ids) {
        int updates =empMapper.deleteByIds(ids);
        return updates;
    }

}
