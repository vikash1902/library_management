package com.example.pyramid;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class PyramidApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PyramidApplication.class);
	}

	public static void main(String[] args) {
		System.out.println("inside pyramid application PyramidApplication");
		SpringApplication.run(PyramidApplication.class, args);
	}

}
