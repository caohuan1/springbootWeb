package com.itheima.pojo;
import lombok.Data;


import java.util.List;

@Data
public class PageBean {
    private long total;//返回总数
    private List rows;//数据列表

    public PageBean(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

}
