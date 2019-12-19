package com.liu.sorm.core;

/**
 * 负责类型转换
 * @author liujy
 *
 */
public interface TypeConvertor {
	
	/**
	 * 将数据库数据类型转换为java数据类型
	 * @param columnType	数据字段的数据类型
	 * @return	java数据类型
	 */
	public String databaseType2JavaType(String columnType);
	
	/**
	 * 将java的数据类型转换为数据库的数据类型
	 * @param javaDataType	java的数据类型
	 * @return	数据库的数据类型
	 */
	public String javaType2DatabaseType(String javaDataType);

}
