package com.itheima.service.impl;

import com.itheima.mapper.DeptLogMapper;
import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;


    @Override
    public List<Dept> list() {
        List<Dept> list = deptMapper.list();
        return list;
    }

    @Transactional(rollbackFor = Exception.class)//此方法开启事务（要么全部成功，事务提交；要么全部失败，事务回滚）
    @Override
    public int delete(Integer id) throws Exception {
        int i;
        try {
            i = deptMapper.deleteById(id);
//        int s= 1/0;  //测试一下，此处会报运行时异常，因为开启了事务，所以需要回滚，删除部门失败
            //        通过部门id删除该部门下的所有员工
            empMapper.deleteByDeptId(id);
            if(true){//该异常不为运行时异常，如果不加rollbackFor = Exception.class，则事务默认不会捕获该异常也不会回滚，会直接提交事务
                throw new Exception("出错了...");
            }
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }
        return i;
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept select(int id) {
        Dept dept = deptMapper.select(id);
        return dept;
    }

    @Override
    public int update(Dept dept) {
        int u = deptMapper.update(dept);
//        dept.setUpdateTime(LocalDateTime.now());
        return u;
    }
}
