package com.mybatis.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public final class SqlSessionUtils {
	private SqlSessionUtils() {
		
	}
	
	public static SqlSession getSqlSession() {

		SqlSession sqlSession = null;
		try {
			InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
			sqlSession = factory.openSession(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
