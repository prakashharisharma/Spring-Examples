package com.td.sb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from users where username=?");
		auth.jdbcAuthentication().dataSource(dataSource)
				.authoritiesByUsernameQuery("select username, role from user_roles where username =?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/h2**").permitAll()
		.antMatchers("/home").access("hasRole('ROLE_USER')")
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").antMatchers("/api/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_API')").and().formLogin().loginProcessingUrl("/login")
				.loginPage("/loginPage").failureUrl("/loginPage?error").defaultSuccessUrl("/home")
				.usernameParameter("username").passwordParameter("password").and().exceptionHandling()
				.accessDeniedPage("/Access_Denied");

		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}
