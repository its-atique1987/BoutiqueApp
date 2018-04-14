package com.example.online.store.MyBoutique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyBoutiqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBoutiqueApplication.class, args);
	}
}

/*@SpringBootApplication
public class MyBoutiqueApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyBoutiqueApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyBoutiqueApplication.class, args);
	}

}*/