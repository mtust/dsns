package com.dsns;

import com.dsns.security.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SpringBootApplication
@Configuration
public class DsnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsnsApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/*");

		return registrationBean;
	}

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {

		return new RepositoryRestConfigurerAdapter() {

			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.setBasePath("/api");
			}
		};
	}

}
