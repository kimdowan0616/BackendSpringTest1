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

import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-self-study.xml")
public class CustomerSelfTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	
	@Test 	// UserMapper.xml에서 namespace로 userNS를 썼을 때의 방식  
	public void session() {
		System.out.println("session() 실행");
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);
	}
	
//	3. Mybatis-Spring의 SqlSessionFactoryBean을 SpringBean으로 등록
	@Test
	public void sessionFactory() {
		System.out.println("sessionFactory() 실행");
		System.out.println(sessionFactory.getClass().getName());
	}	
	
//	1. Properties file 정보 설정
//	2. DataSource 구현체인 HikariDataSource를 SpringBean으로 등록
	@Test
	public void conn() {
		System.out.println("conn() 실행");
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("Self DB Product Name : " + metaData.getDatabaseProductName());
			System.out.println("Self DB Driver : " + metaData.getDriverName());
			System.out.println("Self DB URL : " + metaData.getURL());
			System.out.println("Self DB UserName : " + metaData.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
