package com.rest.restwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebServicesApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver slr=new AcceptHeaderLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

}
