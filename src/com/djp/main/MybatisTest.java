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
	 * 根据主键查找
	 * @throws IOException
	 */
	@Test
	public void findUserById() throws IOException{
		String resource = "com/djp/config/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//表示查询出一条记录进行映射 
		User u = sqlSession.selectOne("test.findById", 1);
		
		System.out.println(u);
		sqlSession.close();
	}
	/**
	 * 根据用户名模糊查询
	 * @throws IOException
	 */
	@Test
	public void findUserByName() throws IOException{
		String resource = "com/djp/config/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//表示查询出多条记录进行映射
		List<User> list = sqlSession.selectList("test.findByName", "面");
		sqlSession.close();
	}
	/**
	 * 插入用户
	 * @throws IOException
	 */
	@Test
	public void insertUser() throws IOException{
		String resource = "com/djp/config/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setName("小花同学");
		user.setPwd("155000");
		user.setAddress("贵州六盘水");
		user.setBrithday(new Date());
		sqlSession.insert("test.inserReturnId", user);
		sqlSession.commit();
	}
	/**
	 * 删除用户
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
	 * 更新用户
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
		user.setName("小宝宝");
		sqlSession.delete("test.updateUser", user);
		sqlSession.commit();
	}
}
