package com.redbonesolutions.highline;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class HighlineApplication {

	@Value("${highline.origin.ui}")
	private String origin;

	@Value("${highline.upload.base}")
	private String uploadBase;

	@Value("${highline.upload.resource}")
	private String uploadResource;

	@Bean
	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurerAdapter() {

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				super.addResourceHandlers(registry);
				registry.addResourceHandler(String.format("%s/**", uploadResource)).addResourceLocations(String.format("file:///%s", uploadBase));
			}

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//registry.addMapping("/service/**").allowedOrigins(origin).allowedHeaders("Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
				registry.addMapping("/service/**").allowedOrigins(origin);
			}

		};

	}

	public static void main(String[] args) {
		SpringApplication.run(HighlineApplication.class, args);
	}
}
