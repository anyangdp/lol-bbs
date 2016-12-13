package com.lolbbs.bootStrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})*/
@ComponentScan(value = {"com.lolbbs.controller"})
@SpringBootApplication//等于上面三个配置
public class Application {
	public static void main(String[] args) {
		/**
		 * 设置热部署是否生效
		 */
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Application.class, args);
	}
}
