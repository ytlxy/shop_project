package com.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shop.mapper")
public class WebOpenApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebOpenApplication.class, args);
	}

}
