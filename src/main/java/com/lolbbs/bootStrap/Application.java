package com.lolbbs.bootStrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import javafx.scene.Parent;

//@Configuration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(value = {"com.lolbbs.controller"})
@SpringBootApplication//等于上面三个配置
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		/**
		 * 设置热部署是否生效
		 */
//		System.setProperty("spring.devtools.restart.enabled", "false");
		/*SpringApplication.run(Application.class, args);
		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);*///第一种

		new SpringApplicationBuilder()
				.sources(Parent.class)
				.child(Application.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

	}

}
