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
		//使用log4j打印日志
		PropertyConfigurator
				.configure("E:/myeclipseWorkspace/mybatis/src/com/djp/config/log4j.properties");
	}
	private SqlSessionFactory SqlSessionFactory;

	@Before//在之前执行  加载总配置文件 得到sqlsessionFacoty
	public void setUp() throws IOException {
		String resource = "com/djp/config/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindById() {
		try {
			//通过得到的SqlSessionFactory打开回话sqlSession
			SqlSession sqlSession = SqlSessionFactory.openSession();
			//通过会话得到用户的代理
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用代理的方法
			User user = userMapper.findById(5);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 用户信息综合查询
	 */
	@Test
	public void testFindUserList() {
		try {
			//通过得到的SqlSessionFactory打开回话sqlSession
			SqlSession sqlSession = SqlSessionFactory.openSession();
			//通过会话得到用户的代理
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用代理的方法
			UserQueryVo userQueryVo = new UserQueryVo();
			
			UserCustom userCustom = new UserCustom();
			userCustom.setAddress("贵州六盘水");
			userCustom.setName("小");
			
			userQueryVo.setUserCustom(userCustom);
			
			int count = userMapper.findUserCount(userQueryVo);
			System.out.println("记录数:"+count);
			List<User> list = userMapper.findUserList(userQueryVo);
			for(User u:list){
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
