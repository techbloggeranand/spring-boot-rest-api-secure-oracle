package com.anandtech.employee.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfigs {

    @Value("${spring.datasource.url}")
    private String url;
	
    @Value("${spring.datasource.username}")
	private String userName;
	
    @Value("${spring.datasource.password}")
	private String password;
	
	
	@Bean
	public NamedParameterJdbcTemplate oracleJdbcTemplate(@Autowired DataSource oracleDataSource) {
		return new NamedParameterJdbcTemplate(oracleDataSource);
	}
	
    @Bean
    public DataSource oracleDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }
}
