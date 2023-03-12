package com.tibame.tga105;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
//@Configuration+@ComponentScan+@EnableAutoConfiguration
public class LabwebJdbcBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabwebJdbcBootApplication.class, args);
	}

}
