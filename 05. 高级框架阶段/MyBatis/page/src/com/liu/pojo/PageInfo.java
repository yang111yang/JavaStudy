package com.liu.pojo;

import java.util.List;

/**
 * ��װ��ҳ�����������
 * @author Administrator
 *
 */
public class PageInfo {
	//ÿҳ�����ݸ���
	private int pageSize;
	//��ǰ��ҳ��
	private int pageNumber;
	//��ҳ��
	private long total;
	//�洢���ݵļ���
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
