package com.liu.server.basic.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 工具类
 * @author liujy
 *
 */
public class WebContext {
	// key-->servlet-name	value-->servlet-class
	private Map<String,String> entityMap = new HashMap<String, String>();
	// key-->servlet-pattern	value-->servlet-name
	private Map<String,String> mappingMap = new HashMap<String, String>();
	public WebContext(List<Entity> entitys, List<Mapping> mappings) {
		for (Entity entity : entitys) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		for (Mapping mapping : mappings) {
			Set<String> patterns = mapping.getPatterns();
			for (String pattern : patterns) {
				mappingMap.put(pattern, mapping.getName());
			}
		}
	}
	
	public String getClz(String pattern) {
		String name = mappingMap.get(pattern);
		return entityMap.get(name);
	}

}
