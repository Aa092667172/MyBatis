package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.User;

public interface UserMapper {
	/**
	 * MyBatis面向介面的兩個一至:
	 * 1.應設文件的namespace要和mapper介面的全類名相同
	 * 2.應設文件中SQL語句的id需要和mapper介面的方法名相同
	 */
	
	/**
	 * 添加用戶信息
	 */
	int insertUser();
	
	/**
	 * 修改
	 */
	void updateUser();
	
	/**
	 * 刪除
	 */
	int deleteUser(); 
	
	/**
	 * 根據id 查詢
	 */
	User getUserById();
	
	/**
	 * 根據name 查詢
	 */
	User getUserByName(String name);
	
	/**
	 * 根據name 查詢
	 */
	User login(String userName,String password);
	
	/**
	 * 根據所有
	 */
	List<User> getAllUser();
}
