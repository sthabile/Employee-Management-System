package com.code.EmployeeManagement.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/index").hasRole("USER")
			.antMatchers("/employee").hasRole("USER")
			.antMatchers("/employeeForm.").hasRole("USER")
			.antMatchers("/employee").hasRole("USER")
			.antMatchers("/edit").hasRole("USER")
			.antMatchers("/delete").hasRole("USER")
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/index.html");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(datasource);
	}
}
