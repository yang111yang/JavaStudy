package com.liu.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * 封装一张表的信息
 * @author liujy
 *
 */
public class TableInfo {
	
	/**
	 * 表名
	 */
	private String name;
	
	/**
	 * 表中所有字段的信息
	 */
	private Map<String,ColumnInfo> columns;
	
	/**
	 * 唯一主键（目前我们只能处理表中有且仅有一个主键的情况）
	 */
	private ColumnInfo onlyPriKey;
	
	/**
	 * 如果联合主键，存储在这里
	 */
	private List<ColumnInfo> priKeys;
	
	public TableInfo() {
		
	}

	public TableInfo(String name, List<ColumnInfo> priKeys, Map<String, ColumnInfo> columns) {
		super();
		this.name = name;
		this.columns = columns;
		this.priKeys = priKeys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}

	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}

	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}

	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}
	
	

}
