package com.taotao.common.pojo;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/9 20:21.
 */
public class EasyUIDateGridResult {
    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
