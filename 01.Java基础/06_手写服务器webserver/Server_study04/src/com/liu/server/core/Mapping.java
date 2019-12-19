package com.liu.server.core;

import java.util.HashSet;
import java.util.Set;

/**
 * web.xml中servlet-mapping的实体类
 * @author liujy
 *
 */
public class Mapping {
	
	private String name;
	private Set<String> patterns = null;
	
	public Mapping() {
		patterns = new HashSet<String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getPatterns() {
		return patterns;
	}

	public void setPatterns(Set<String> patterns) {
		this.patterns = patterns;
	}

	public void addPattern(String pattern) {
		this.patterns.add(pattern);
	}
}
