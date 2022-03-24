package com.mybatis.t_usertest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void testMyBatisConfig() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		// 獲取sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		// 獲取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		// openSession方法接收true時 autocommit為true
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> allUser = mapper.getAllUser();
		allUser.forEach(System.out::println);
	}
	
	@Test
	public void deleteUser() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.deleteUser(3);
	}
	
	@Test
	public void selectUserById() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.getUserById(2);
		System.out.println(user);
	}
	
	@Test
	public void updateUser() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.updateUser(new User(1,"小吳","ji32k7au4a83",30,"男","test@yahoo.com.tw"));
	}
	
	@Test
	public void insertUser() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		User vo = new User();
		vo.setEmail("qqp15601560@yahoo.com.tw");
		vo.setAge(20);
		vo.setPassword("test");
		vo.setUserName("阿森");
		vo.setSex("男");
		
		mapper.insertUser(vo);
	}
	

	@Test
	public void getAllUser() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		var list = mapper.getAllUser();
		list.forEach(System.out::println);

	}

	@Test
	public void getUserByUserName() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User userByName = mapper.getUserByName("阿森");
		System.out.println(userByName);
	}

	@Test
	public void login() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User loginUser = mapper.login("阿森", "test");
		System.out.println(loginUser);
	}
	
	@Test
	public void checkLoginByMap() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Map<String,Object> map = new HashMap<>();
		
		map.put("userName", "阿森");
		map.put("password", "test");
		
		User loginUser = mapper.checkLoginByMap(map);
		System.out.println(loginUser);
	}
	
	@Test
	public void checkLoginByParam() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User loginUser = mapper.checkLoginByParam("阿森","test");
		System.out.println(loginUser);
	}
}
