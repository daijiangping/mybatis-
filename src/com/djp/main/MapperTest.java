package com.djp.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import com.djp.config.mapper.UserMapper;
import com.djp.pojo.User;
import com.djp.pojo.UserCustom;
import com.djp.pojo.UserQueryVo;

public class MapperTest {
	static {
		//ʹ��log4j��ӡ��־
		PropertyConfigurator
				.configure("E:/myeclipseWorkspace/mybatis/src/com/djp/config/log4j.properties");
	}
	private SqlSessionFactory SqlSessionFactory;

	@Before//��֮ǰִ��  �����������ļ� �õ�sqlsessionFacoty
	public void setUp() throws IOException {
		String resource = "com/djp/config/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindById() {
		try {
			//ͨ���õ���SqlSessionFactory�򿪻ػ�sqlSession
			SqlSession sqlSession = SqlSessionFactory.openSession();
			//ͨ���Ự�õ��û��Ĵ���
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//���ô���ķ���
			User user = userMapper.findById(5);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * �û���Ϣ�ۺϲ�ѯ
	 */
	@Test
	public void testFindUserList() {
		try {
			//ͨ���õ���SqlSessionFactory�򿪻ػ�sqlSession
			SqlSession sqlSession = SqlSessionFactory.openSession();
			//ͨ���Ự�õ��û��Ĵ���
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//���ô���ķ���
			UserQueryVo userQueryVo = new UserQueryVo();
			
			UserCustom userCustom = new UserCustom();
			userCustom.setAddress("��������ˮ");
			userCustom.setName("С");
			
			userQueryVo.setUserCustom(userCustom);
			
			int count = userMapper.findUserCount(userQueryVo);
			System.out.println("��¼��:"+count);
			List<User> list = userMapper.findUserList(userQueryVo);
			for(User u:list){
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
