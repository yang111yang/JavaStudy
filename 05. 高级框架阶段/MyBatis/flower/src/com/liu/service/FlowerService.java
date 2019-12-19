package com.liu.service;

import java.util.List;

import com.liu.pojo.Flower;

public interface FlowerService {
	/**
	 * 查询所有信息
	 * @return
	 */
	List<Flower> selAll();
	
	/**
	 * 添加花卉信息
	 * @param flower
	 * @return
	 */
	int addFlower(Flower flower);
}
