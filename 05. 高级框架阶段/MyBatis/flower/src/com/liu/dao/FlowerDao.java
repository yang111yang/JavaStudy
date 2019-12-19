package com.liu.dao;

import java.util.List;

import com.liu.pojo.Flower;

public interface FlowerDao {
	/**
	 * 查询所有信息
	 * @return
	 */
	List<Flower> selAll();
	
	/**
	 * 添加花卉
	 * @param flower
	 * @return
	 */
	int addFlower(Flower flower);
}
