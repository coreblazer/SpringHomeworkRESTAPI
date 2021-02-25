package com.example.SpringHomeworkRESTAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("controllers")
@SpringBootApplication
public class SpringHomeworkRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHomeworkRestapiApplication.class, args);
	}

}
