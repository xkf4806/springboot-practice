package com.springboot.demo01.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinj.xue
 * @description：
 * @date 2017-09-12 22:32
 **/
public class PageInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private int totalCount;

    /**
     * 分页总数
     */
    private int totalPage;

    /**
     * 每页的记录尺寸
     */
    private int pageSize=10;

    /**
     *当前的页号,从0开始
     */
    private int pageNum;

    /**
     * 当前分页数据
     */
    private List data;

    public PageInfo(){

    }

    public PageInfo(int pageSize, int pageNum){
        this.pageSize=pageSize;
        this.pageNum=pageNum;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;

        //计算分页总数
        if(this.pageSize>0){
            this.totalPage=this.totalCount/this.pageSize+(this.totalCount%this.pageSize==0?0:1);
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }


}
