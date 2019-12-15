package com.liu.sorm.core;

/**
 * mysql的数据类型和java的数据类型之间的转换
 * @author liujy
 *
 */
public class MysqlTypeConvertor implements TypeConvertor {

	@Override
	public String databaseType2JavaType(String columnType) {
		if ("varchar".equalsIgnoreCase(columnType) || "char".equalsIgnoreCase(columnType)) {
			return "String";
		} else if ("int".equalsIgnoreCase(columnType) 
				|| "tinyint".equalsIgnoreCase(columnType)
				|| "smallint".equalsIgnoreCase(columnType)
				|| "mediumint".equalsIgnoreCase(columnType)
				|| "integer".equalsIgnoreCase(columnType)) {
			return "Integer";
		} else if ("bigint".equalsIgnoreCase(columnType)) {
			return "Long";
		} else if ("double".equalsIgnoreCase(columnType) || "float".equalsIgnoreCase(columnType)) {
			return "Double";
		} else if ("date".equalsIgnoreCase(columnType)) {
			return "Date";
		} else if ("time".equalsIgnoreCase(columnType)) {
			return "Time";
		} else if ("timestamp".equalsIgnoreCase(columnType)) {
			return "Timestamp";
		} else if ("clob".equalsIgnoreCase(columnType)) {
			return "Clob";
		} else if ("blob".equalsIgnoreCase(columnType)) {
			return "Blob";
		}
		return null;
	}

	@Override
	public String javaType2DatabaseType(String javaDataType) {
		// TODO Auto-generated method stub
		return null;
	}

}
