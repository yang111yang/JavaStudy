package com.liu.sorm.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.liu.sorm.bean.ColumnInfo;
import com.liu.sorm.bean.JavaFieldGetSet;
import com.liu.sorm.bean.TableInfo;
import com.liu.sorm.core.DBManager;
import com.liu.sorm.core.MysqlTypeConvertor;
import com.liu.sorm.core.TableContext;
import com.liu.sorm.core.TypeConvertor;

/**
 * 封装生成javabean的操作
 * @author liujy
 *
 */
public class JavaFileUtils {

	/**
	 * 生成指定字段的javabean属性和set、get方法的源代码
	 * @param column	属性信息
	 * @param convertor	类型转换器
	 * @return	生成的JavaFieldGetSet对象
	 */
	public static JavaFieldGetSet createJavaFieldSetGetSRC(ColumnInfo column, TypeConvertor convertor) {
		// 获取字段对应的java的数据类型
		String javaDataType = convertor.databaseType2JavaType(column.getDataType());
		
		// 生成属性的源码
		JavaFieldGetSet jfgs = new JavaFieldGetSet();
		jfgs.setFieldInfo("\tprivate "+javaDataType+" "+column.getName()+";\n");
		
		// 生成get方法的源码
		StringBuilder getSrc = new StringBuilder();
		getSrc.append("\tpublic "+javaDataType+" get"+StringUtils.convertFirstChar2UpperCase(column.getName())+"(){\n")
			.append("\t\treturn "+column.getName()+";\n")
			.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());
		
		// 生成get方法的源码
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set"+StringUtils.convertFirstChar2UpperCase(column.getName())+"("+javaDataType+" "+column.getName()+"){\n")
		.append("\t\tthis."+column.getName()+"="+column.getName()+";\n")
		.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}
	
	/**
	 * 生成指定表对应的javabean的源码
	 * @param table	表信息
	 * @param convertor	类型转换器
	 * @return	生成的源码
	 */
	public static String createJavaSrc(TableInfo table, TypeConvertor convertor) {
		Map<String, ColumnInfo> columns = table.getColumns();
		List<JavaFieldGetSet> fields = new ArrayList<JavaFieldGetSet>();
		// 将所有的table中的字段信息存储到List中
		for (ColumnInfo c : columns.values()) {
			fields.add(createJavaFieldSetGetSRC(c, convertor));
		}
		
		StringBuilder src = new StringBuilder();
		// 生成package语句
		src.append("package "+DBManager.getConf().getPoPackage()+";\n\n");
		// 生成import语句
		src.append("import java.sql.*;\n").append("import java.util.*;\n\n");
		// 生成类声明语句
		src.append("public class "+StringUtils.convertFirstChar2UpperCase(table.getName())+" {\n\n");
		// 生成属性列表
		for (JavaFieldGetSet jf : fields) {
			src.append(jf.getFieldInfo());
		}
		src.append("\n");
		// 生成无参构造器
		src.append("\tpublic "+StringUtils.convertFirstChar2UpperCase(table.getName())+"() {\n").append("\t}\n\n");
		// 生成有参构造器
		
		src.append("\tpublic "+StringUtils.convertFirstChar2UpperCase(table.getName())+"(");
		for (ColumnInfo c : columns.values()) {
			src.append(convertor.databaseType2JavaType(c.getDataType())+" "+c.getName()+", ");
		}
		src = new StringBuilder(src.substring(0, src.length()-2));
		src.append(") {\n");
		src.append("\t\tsuper();\n");
		for (ColumnInfo c : columns.values()) {
			src.append("\t\tthis."+c.getName()+"="+c.getName()+";\n");
		}
		src.append("\t}\n\n");
		// 生成get方法列表
		for (JavaFieldGetSet jf : fields) {
			src.append(jf.getGetInfo()+"\n");
		}
		// 生成set方法列表
		for (JavaFieldGetSet jf : fields) {
			src.append(jf.getSetInfo()+"\n");
		}
		// 生成类结束语句
		src.append("}");
		return src.toString();
	}
	
	/**
	 * 生成数据库表对应的java类
	 * @param table	数据库表信息
	 * @param convertor	类型转换器
	 */
	public static void createJavaPOFile(TableInfo table, TypeConvertor convertor) {
		// 获取po包的路径
		String srcPath = DBManager.getConf().getSrcPath()+"/";
		String poPath = DBManager.getConf().getPoPackage().replaceAll("\\.", "\\\\");
		File f = new File(srcPath+poPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		// 将src源代码写到文件中
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(
				f+"\\"+StringUtils.convertFirstChar2UpperCase(table.getName())+".java"))) {
			String src = createJavaSrc(table, convertor);
			bw.write(src);
			System.out.println("生成了"+table.getName()+"表对应的java类："+
					StringUtils.convertFirstChar2UpperCase(table.getName())+".java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
//		ColumnInfo column = new ColumnInfo("id", "int", 0);
//		JavaFieldGetSet jfgs = createJavaFieldSetGetSRC(column, new MysqlTypeConvertor());
//		System.out.println(jfgs);
		Map<String, TableInfo> tables = TableContext.tables;
		for (TableInfo table : tables.values()) {
			createJavaPOFile(table, new MysqlTypeConvertor());
		}
	}
	
}
