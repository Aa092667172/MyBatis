package com.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mybatis.pojo.User;

public interface UserMapper {
	/**
	 * MyBatis面向介面的兩個一至:
	 * 1.映設文件的namespace要和mapper介面的全類名相同
	 * 2.映設文件中SQL語句的id需要和mapper介面的方法名相同
	 */
	User checkLoginByMap(Map<String,Object> map);
	
	/**
	 * 以@Param值為key 參數值為value
	 * @param uaerName
	 * @param password
	 * @return
	 */
	User checkLoginByParam(@Param("usernameTest") String userName,@Param("passwordTest") String password);
	/**
	 * 添加用戶信息
	 */
	int insertUser(User vo);
	
	/**
	 * 修改
	 */
	void updateUser(User vo);
	
	/**
	 * 刪除
	 */
	int deleteUser(Integer id); 
	
	/**
	 * 根據id 查詢
	 */
	User getUserById(Integer id);
	
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
