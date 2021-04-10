package com.liujf.springboot01;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//关掉SpringbootSecurity
@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 在平常开发中可能需要实现在启动后执行的功能，Springboot提供了一种简单的实现方案，即实现CommandLineRunner接口
     * 当服务中有多个CommandLineRunner对象时，默认情况下是按照自然顺序执行的。可以通过@Order指定执行顺序
     * CommandLineRunner和ApplicationRunner的区别二者的功能和官方文档一模一样，都是在Spring容器初始化完毕之后执行起run方法,
     * 不同点在于，前者的run方法参数是String...args，直接传入字符串,后者的参数是ApplicationArguments，对参数进行了封装
     * @param ctx
     * @return
     */
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
//				System.out.println(beanName);
			}

		};
	}
}
