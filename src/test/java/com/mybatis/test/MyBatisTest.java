package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtils;

public class MyBatisTest {
	@Test
	public void testMyBatisCRUD() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		// 獲取sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		// 獲取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		// openSession方法接收true時 autocommit為true
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//		mapper.updateUser();
//		mapper.insertUser();
//		mapper.deleteUser();
//		User userById = mapper.getUserById();
//		System.out.println(userById);
		List<User> allUser = mapper.getAllUser();
		allUser.forEach(System.out::println);
	}

	@Test
	public void testGetAllUser() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		var list = mapper.getAllUser();
		list.forEach(System.out::println);

	}

	@Test
	public void testGetUserByUserName() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User userByName = mapper.getUserByName("阿森");
		System.out.println(userByName);
	}

	@Test
	public void testLogin() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User loginUser = mapper.login("test", "gogotest");
		System.out.println(loginUser);
	}
}
