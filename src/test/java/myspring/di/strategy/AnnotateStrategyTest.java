package myspring.di.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import homework.myspring.di.strategy2.service.UserServiceImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:strategyTest-annot.xml")
public class AnnotateStrategyTest {

	@Autowired
	UserServiceImpl usi;
	
	@Test
	public void test() {
		System.out.println(usi.getUserList().size());
		Assertions.assertEquals(2, usi.getUserList().size());
	}
}
