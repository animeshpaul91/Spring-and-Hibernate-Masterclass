package com.luv2code.springboot.thymeleafdemo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
// a. Configure Spring Data JPA
@EnableJpaRepositories(basePackages = { "${spring.data.jpa.repository.packages}" })
/*
 * This tells the app that we are using JPA repositories defined in the given
 * package. The package name is read from the application.properties file.
 * Spring Data JPA will scan for JPA repositories in this package. Spring Data
 * JPA makes use of a entity manager factory bean and transacation manager. By
 * default it will use a bean named, "entityManagerFactory". We manually
 * configure this bean in this class. Also, by default, Spring Data JPA will use
 * a bean named "transactionManager". The "transactionManager" bean is
 * autoconfigured by Spring Boot.
 */
public class DemoDataSourceConfig {

	// b. Configure application DataSource
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "app.datasource") // tells the app that employee data is the primary datasource
														// for the app. This is obtained from the properties file
	public DataSource appDataSource() {
		return DataSourceBuilder.create().build();
	}

	// c. Configure EntityManagerFactory
	/*
	 * The entity manager factory tells Spring Data JPA which packages to scan for
	 * JPA entities. The @ConfigurationProperties will read properties from the
	 * config file (application.properties). It will read the properties from the
	 * file with the prefix: "spring.data.jpa.entity"
	 */

	@Bean
	@ConfigurationProperties(prefix = "spring.data.jpa.entity")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			DataSource appDataSource) {
		return builder.dataSource(appDataSource).build();
	}

	// d. Configure Data Source for Security
	/*
	 * Here we configure the datasource to access the security database. By default,
	 * Spring Security makes use of regular JDBC (no JPA). As a result, we only need
	 * a datasource so the configuration is a bit simpler.
	 * 
	 * The @ConfigurationProperties will read properties from the config file
	 * (application.properties). It will read the properties from the file with the
	 * prefix: "security.datasource".
	 */
	@Bean
	@ConfigurationProperties(prefix = "security.datasource")
	public DataSource securityDataSource() {
		return DataSourceBuilder.create().build();
	}
}
