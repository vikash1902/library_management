package com.example.pyramid;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "${openApi.title}",
				version = "${openApi.version}",
				contact = @Contact(
						name = "${openApi.contact.name}", email = "${openApi.contact.email}", url = "${openApi.contact.url}"
				),
				license = @License(
						name = "${openApi.license.name}", url = "${openApi.license.url}"
				),
				termsOfService = "${openApi.termsOfService}",
				description = "${openApi.desc}"
		),
		servers = @Server(
				url = "${openApi.server.url}",
				description = "${openApi.server.desc}"
		)
)
@SecurityScheme(
		name = "bearerAuth",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "Bearer"
)
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
