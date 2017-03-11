package com.djp.dao;

import java.util.List;

import com.djp.pojo.User;

public interface IUserDao {
	/**
	 * 根据ID查找用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User findUserById(int id) throws Exception;
	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	List<User> findUserByName(String name) throws Exception;
	/**
	 * 修改用户
	 * @param user
	 * @throws Exception
	 */
	void update(User user) throws Exception;
	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	void delete(int id) throws Exception;
	
}
