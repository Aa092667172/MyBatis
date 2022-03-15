package com.mybatis.pojo;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private String userName;
	private String password;
	private Integer age;
	private String sex;
	private String email;
	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param age
	 * @param sex
	 * @param email
	 */
	public User(Integer id, String userName, String password, Integer age, String sex, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.email = email;
	}
	/**
	 * 
	 */
	public User() {
		super();
	}
	
	
}
