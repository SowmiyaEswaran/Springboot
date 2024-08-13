package com.boot.MultipleDataSource.configuration;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "userEntityMangerFactory", transactionManagerRef = "userTransactionManger", basePackages = {"com.boot.MultipleDataSource.Repository.user"})
@EnableTransactionManagement
public class UserConfiguration {
	
	@Bean(name = "userdataSource")
	@ConfigurationProperties(prefix = "spring.user.datasource")
	public DataSource datasource() {
		return DataSourceBuilder.create().build();
		/*
		 * .driverClassName("com.mysql.cj.jdbc.Driver")
		 * .url("jdbc:mysql://localhost:3306/sys") .username("root") .password("")
		 * .build();
		 */	}
	@Bean(name = "userEntityMangerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("userdataSource")DataSource datasource) {
		HashMap<String, Object> props = new HashMap<String, Object>();
		//props.put("hibernate.ddl-auto", "update");
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return builder.dataSource(datasource).packages("com.boot.MultipleDataSource.domain.user").properties(props).persistenceUnit("User")
                .build();
		}

	@Bean(name = "userTransactionManger")
	public PlatformTransactionManager transactionManger(@Qualifier("userEntityMangerFactory")EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
		
	}
	
}
