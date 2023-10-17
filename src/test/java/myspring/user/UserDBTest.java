package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-user.xml")
public class UserDBTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserService userService;
	
	@Test
	public void service() {
		UserVO user = userService.getUser("dooly");
		System.out.println("service() >> " + user);
	}
	
	@Test @Disabled
	public void mapper() {
		UserVO user = userMapper.selectUserById("dooly");
		System.out.println("37 mapper() >> " + user);
	}
	
	@Test @Disabled	// UserMapper.xml에서 namespace로 userNS를 썼을 때의 방식  
	public void session() {
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);
	}
	
	@Test
	public void sessionFactory() {
		System.out.println(sessionFactory.getClass().getName());
	}
	
	@Test
	public void conn() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB Product Name : " + metaData.getDatabaseProductName());
			System.out.println("DB Driver : " + metaData.getDriverName());
			System.out.println("DB URL : " + metaData.getURL());
			System.out.println("DB UserName : " + metaData.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
