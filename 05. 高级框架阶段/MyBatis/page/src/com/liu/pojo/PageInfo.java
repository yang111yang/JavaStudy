package com.liu.pojo;

import java.util.List;

/**
 * 封装分页功能所需变量
 * @author Administrator
 *
 */
public class PageInfo {
	//每页的数据个数
	private int pageSize;
	//当前的页数
	private int pageNumber;
	//总页数
	private long total;
	//存储数据的集合
	private List<?> list;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
}
