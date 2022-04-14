package com.newkewang.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaozhi
 * @description 封装分页相关信息
 * @create 2022-03-2022/3/23 22:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    /**
     *  当前页码
     */
    private Integer current = 1;
    /**
     *  显示上限
     */
    private Integer limit = 10;
    /**
     *  数据总数（用于计算总也页数）
     */
    private Integer rows;
    /**
     *  查询路径（用于复用分页链接）
     */
    private String path;

    public void setCurrent(Integer current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public void setLimit(Integer limit) {
        if (limit >= 1 && limit <= 20) {
            this.limit = limit;
        }
    }

    public void setRows(Integer rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    /**
     * 获取当前页起始行
     * @return
     */
    public int getOffset() {
        // current * limit - limit
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit + 1;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取起始页码
     * @return
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获取结束页码
     * @return
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}
