package myspring.di.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import homework.myspring.di.strategy1.dao.UserDaoImpl;
import homework.myspring.di.strategy1.service.UserServiceImpl;

public class StrategyTest {
	BeanFactory factory;
	
	@BeforeEach
	void init() {
		factory = new GenericXmlApplicationContext("classpath:strategyTest.xml");		
	}
	
	@Test
	void test() {
		UserDaoImpl udi = (UserDaoImpl)factory.getBean("userDaoImpl");
		UserServiceImpl usi = (UserServiceImpl)factory.getBean("userServiceImpl");

		assertEquals(2, usi.getUserList().size());
		
		System.out.println(usi.getUserList());
	}
}
