package com.example.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 * <p>Description：分页</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/19 18:15
 */

@AllArgsConstructor
@NoArgsConstructor
public class Paging implements Pageable, Serializable {
    @Getter
    @Setter
    private Integer pageNum = 1;
    @Setter
    private Integer pageSize = 10;
    @Getter
    @Setter
    private Integer totalSize = 10;

    @Setter
    private Sort sort = Sort.unsorted();
    @Getter
    @Setter
    private List data;

    Paging(Integer pageNum, Integer pageSize, Sort sort) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.sort = sort;
    }


    public static Paging createNoPaging() {
        Paging paging = new Paging();
        paging.setPageSize(Integer.MAX_VALUE);
        return paging;
    }

    /**
     * <p>方法名:generatePaging </p>
     * <p>描述: 根据JPA返回的结果(@see org.springframework.data.domain.Page)封装成自己想要的结果</p>
     * <p>创建时间: 2019/12/23 9:26</p>
     *
     * @param content JPA 返回的分页结果
     * @return Paging
     * @author mojinpeng
     */
    public static Paging generatePaging(Page content) {
        Paging page = new Paging();
        page.setPageSize(content.getPageable().getPageSize());
        page.setData(content.getContent());
        page.setPageNum(content.getPageable().getPageNumber());
        page.setTotalSize((int) content.getTotalElements());
        return page;

    }

    @Override
    public int getPageNumber() {
        return pageNum;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public long getOffset() {
        return (long) pageNum * (long) pageSize;
    }


    @Override
    public Sort getSort() {
        return sort;
    }


    /**
     * <p>描述: 下一页信息</p>
     * <p>创建时间: 2019/12/20 17:32</p>
     *
     * @return Pageable
     * @author mojinpeng
     */
    @Override
    public Pageable next() {
        return new Paging(getPageNum() + 1, getPageSize(), getSort());

    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    private Paging previous() {
        return getPageNumber() == 0 ? this : new Paging(getPageNumber() - 1, getPageSize(), getSort());
    }

    @Override
    public Pageable first() {
        return new Paging(0, getPageSize(), getSort());
    }


    @Override
    public boolean hasPrevious() {
        return this.pageNum > 0;
    }

}
