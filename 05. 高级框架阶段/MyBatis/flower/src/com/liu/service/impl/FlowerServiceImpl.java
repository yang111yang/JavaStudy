package com.liu.service.impl;

import java.util.List;

import com.liu.dao.FlowerDao;
import com.liu.dao.impl.FlowerDaoImpl;
import com.liu.pojo.Flower;
import com.liu.service.FlowerService;

public class FlowerServiceImpl implements FlowerService {
	FlowerDao flowerDao = new FlowerDaoImpl();
	@Override
	public List<Flower> selAll() {
		return flowerDao.selAll();
	}
	@Override
	public int addFlower(Flower flower) {
		return flowerDao.addFlower(flower);
	}

}
