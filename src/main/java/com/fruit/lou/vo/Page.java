package com.fruit.lou.vo;

import java.util.List;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 16:44
 */
public class Page<T> {
    private int pageNumber;

    private int pageSize;

    private int total;

    private int totalPage;

    private int totalRow;

    private List<T> list;

    public Page() {}

    public Page(int pageNumber, int pageSize, int total, int totalPage, int totalRow, List<T> list) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
        this.totalPage = totalPage;
        this.totalRow = totalRow;
        this.list = list;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
