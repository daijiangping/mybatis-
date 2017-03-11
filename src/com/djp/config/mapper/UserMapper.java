package com.djp.config.mapper;

import java.util.List;

import com.djp.pojo.User;
import com.djp.pojo.UserQueryVo;

public interface UserMapper {
	/**
	 * �û���Ϣ�ۺϲ�ѯ ͳ��
	 * @param userQueryVo
	 * @return
	 */
	 int findUserCount(UserQueryVo userQueryVo);
	/**
	 * �û���Ϣ�ۺϲ�ѯ
	 * @param userCustom
	 * @return
	 */
	List<User> findUserList(UserQueryVo userQueryVo);
	/**
	 * ����ID�����û�
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
	 * �����û�
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
	 * �޸�
	 * @param user
	 * @throws Exception
	 */
	void updateUser(User user)throws Exception;
	
}
