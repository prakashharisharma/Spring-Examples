package com.td.sb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/home").access("hasRole('ROLE_USER')")
				.antMatchers("/hi/**").authenticated()
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").antMatchers("/api/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_API')").and().formLogin().loginProcessingUrl("/login")
				.loginPage("/loginPage").failureUrl("/loginPage?error").defaultSuccessUrl("/home")
				.usernameParameter("username").passwordParameter("password").and().exceptionHandling()
				.accessDeniedPage("/Access_Denied");

		http.csrf().disable();
		http.headers().frameOptions().disable();

	}

}
