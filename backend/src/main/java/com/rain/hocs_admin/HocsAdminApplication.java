package com.rain.hocs_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
public class HocsAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(HocsAdminApplication.class, args);
	}

}
