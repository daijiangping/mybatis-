package com.djp.dao;

import java.util.List;

import com.djp.pojo.User;

public interface IUserDao {
	/**
	 * ����ID�����û�
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
	 * �޸��û�
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
