package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    //统计返回总数量
    @Select("select count(*) from emp ")
    Integer count();

    //分页查询
    @Select("select * from emp limit #{start},#{pageSize}")
    List<Emp> page(Integer start, Integer pageSize );

    //使用PageHelper包实现分页查询
//    @Select("select * from emp")
    List<Emp> pageHelper(String name, Short gender, LocalDate begin, LocalDate end);//注意：此处方法名不能使用page()，也就是不能使用方法重载，否则springboot项目启动会报错

    void deleteByIds(List<Integer> ids) ;
}
