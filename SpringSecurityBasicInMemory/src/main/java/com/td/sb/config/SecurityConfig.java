package com.td.sb.config;

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
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN", "API");
		auth.inMemoryAuthentication().withUser("apiuser").password("123456").roles("API");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/home").permitAll()
			.antMatchers("/admin/**")
			.access("hasRole('ROLE_ADMIN')").antMatchers("/api/**")
			.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_API')").and().formLogin().and().exceptionHandling()
			.accessDeniedPage("/Access_Denied");

	}
}
