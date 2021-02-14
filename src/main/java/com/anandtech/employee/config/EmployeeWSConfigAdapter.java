package com.anandtech.employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.anandtech.employee.security.EmployeeBasicAuthEntryPoint;

@Configuration
@EnableWebSecurity
public class EmployeeWSConfigAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private EmployeeBasicAuthEntryPoint authenticationEntryPoint;
    
    @Value("${admin-user}")
    private String userName;

    @Value("${admin-pwd}")
    private String password;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser(userName).password(passwordEncoder().encode(password))
          .authorities("ROLE_USER");
    }

    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.anyRequest().authenticated()
				.and().httpBasic()
				.authenticationEntryPoint(authenticationEntryPoint);
	}
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}