package com.djp.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.djp.pojo.User;

public class MybatisTest {
	static{  
        PropertyConfigurator.configure("E:/myeclipseWorkspace/mybatis/src/com/djp/config/log4j.properties");  
	}
	/**
	 * ������������
	 * @throws IOException
	 */
	@Test
	public void findUserById() throws IOException{
		String resource = "com/djp/config/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//��ʾ��ѯ��һ����¼����ӳ�� 
		User u = sqlSession.selectOne("test.findById", 1);
		
		System.out.println(u);
		sqlSession.close();
	}
	/**
	 * �����û���ģ����ѯ
	 * @throws IOException
	 */
	@Test
	public void findUserByName() throws IOException{
		String resource = "com/djp/config/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//��ʾ��ѯ��������¼����ӳ��
		List<User> list = sqlSession.selectList("test.findByName", "��");
		sqlSession.close();
	}
	/**
	 * �����û�
	 * @throws IOException
	 */
	@Test
	public void insertUser() throws IOException{
		String resource = "com/djp/config/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setName("С��ͬѧ");
		user.setPwd("155000");
		user.setAddress("��������ˮ");
		user.setBrithday(new Date());
		sqlSession.insert("test.inserReturnId", user);
		sqlSession.commit();
	}
	/**
	 * ɾ���û�
	 * @throws IOException
	 */
	@Test
	public void deleteUser() throws IOException{
		String resource = "com/djp/config/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser", 8);
		sqlSession.commit();
	}
	/**
	 * �����û�
	 * @throws IOException
	 */
	@Test
	public void updateUser() throws IOException{
		String resource = "com/djp/config/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(6);
		user.setName("С����");
		sqlSession.delete("test.updateUser", user);
		sqlSession.commit();
	}
}
