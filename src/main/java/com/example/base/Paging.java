package com.example.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>Description：分页</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/19 18:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paging {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Integer totalSize = 10;

    private List data;


    public static Paging createNoPaging() {
        Paging paging = new Paging();
        paging.setPageSize(Integer.MAX_VALUE);
        return paging;
    }



}
