package myspring.di.strategy.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import homework.myspring.di.strategy2.annot.config.UserConfig;
import homework.myspring.di.strategy2.service.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserConfig.class,
		loader = AnnotationConfigContextLoader.class )
public class StrategyAnnotConfigTest {
	
	@Autowired
	UserService userService;
	
	@Test
	public void test() {
		System.out.println(userService.getClass().getName());
	}
}
