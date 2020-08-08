package com.customer.dbDao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:/vehicle.properties")
public class DBConfig {

	@Autowired
	private Environment env;

	/*
	 * <bean id="pdataSource"
	 * class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	 * <property name="driverClassName" value="${db.driver}" /> <property name="url"
	 * value="${db.url}" /> <property name="username" value="${db.username}" />
	 * <property name="password" value="${db.password}" /> </bean>
	 */

	@Bean("dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// MySQL database we are using
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));// change url
		dataSource.setUsername(env.getProperty("db.username"));// change userid
		dataSource.setPassword(env.getProperty("db.password"));// change pwd
		return dataSource;
	}
	
	

	@Bean("jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

}