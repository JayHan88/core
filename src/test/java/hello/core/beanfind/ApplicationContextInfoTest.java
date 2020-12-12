package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 빈 출력하기")
	void finrAllBean() {
		String[] beandefinitionNames = ac.getBeanDefinitionNames();
		for (String beandefinitionName : beandefinitionNames) {
			Object bean = ac.getBean(beandefinitionName);
			System.out.println("bean = " + beandefinitionName + " object = " + bean);
		}
	}

	@Test
	@DisplayName("애플리케이션 빈 출력하기")
	void findApplicationBean() {
		String[] beandefinitionNames = ac.getBeanDefinitionNames();
		for (String beandefinitionName : beandefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beandefinitionName);

			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beandefinitionName);
				System.out.println("bean = " + beandefinitionName + " object = " + bean);
			}
		}
	}
}
