package com.mybatis.mapper;

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
}
