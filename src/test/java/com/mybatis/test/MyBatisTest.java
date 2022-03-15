package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.mybatis.mapper.UserMapper;

public class MyBatisTest {
	@Test
	public void testMyBatis() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		//獲取sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		//獲取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//openSession方法接收true時 autocommit為true
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		int insertUser = mapper.insertUser();
		System.out.println("reuslt = " +insertUser);
	}
}
