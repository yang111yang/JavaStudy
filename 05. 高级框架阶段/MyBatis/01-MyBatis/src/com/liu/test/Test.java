package com.liu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		//���ֲ�ѯ��ʽ
		//��ѯList
//		List<Flower> list = session.selectList("com.liu.mapper.FlowerMapper.selAll");
//		for (Flower flower : list) {
//			System.out.println(flower);
//		}
		//��ѯһ����������һ������
//		int selectOne = session.selectOne("com.liu.mapper.FlowerMapper.selById");
//		System.out.println(selectOne);
		//��ѯ�Ľ����һ��map
		Map<Object,Object> map = session.selectMap("com.liu.mapper.FlowerMapper.selMap", "name");
		System.out.println(map);
		session.close();
	}
}
