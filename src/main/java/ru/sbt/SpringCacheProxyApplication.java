package ru.sbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbt.service.Utils;
import ru.sbt.service.UtilsImpl;

@SpringBootApplication
@ImportResource({"classpath*:config.xml"})
public class SpringCacheProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheProxyApplication.class, args);
		System.out.println("-=-==-=-=-=-=");
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Utils util = (Utils) context.getBean("utils");
		System.out.println(util.doWorker("doWorkEasy", 5));
		System.out.println(util.doWorker("doWorkEasy", 5));
	}
}
