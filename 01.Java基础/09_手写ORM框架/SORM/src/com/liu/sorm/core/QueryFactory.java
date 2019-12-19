package com.liu.sorm.core;

/**
 * 负责根据配置信息创建query对象
 * @author liujy
 *
 */
public class QueryFactory {
	
	/**
	 * 原型对象
	 */
	private static Query prototypeObj; 
	
	static {
		try {
			Class<?> clazz = Class.forName(DBManager.getConf().getQueryClass());
			prototypeObj = (Query) clazz.getConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 加载po包下所有的子类
		TableContext.loadPOTableInfo();
		
	}
	
	private QueryFactory() { // 私有化构造器
	}
	
	public static Query createQuery() {
		try {
			return (Query) prototypeObj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
