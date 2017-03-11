package com.djp.config.mapper;

import java.util.List;

import com.djp.pojo.User;
import com.djp.pojo.UserQueryVo;

public interface UserMapper {
	/**
	 * 用户信息综合查询 统计
	 * @param userQueryVo
	 * @return
	 */
	 int findUserCount(UserQueryVo userQueryVo);
	/**
	 * 用户信息综合查询
	 * @param userCustom
	 * @return
	 */
	List<User> findUserList(UserQueryVo userQueryVo);
	/**
	 * 根据ID查找用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User findById(int id) throws Exception;
	/**
	 * @param name
	 * @return
	 * @throws Exception
	 */
	List<User> findByName(String name) throws Exception;
	/**
	 * 插入用户
	 * @param user
	 * @throws Exception
	 */
	void insertUser(User user) throws Exception;
	/**
	 * @param id
	 * @throws Exception
	 */
	void deleteUser(int id) throws Exception;
	/**
	 * 修改
	 * @param user
	 * @throws Exception
	 */
	void updateUser(User user)throws Exception;
	
}
