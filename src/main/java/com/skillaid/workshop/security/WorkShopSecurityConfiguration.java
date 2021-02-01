package com.skillaid.workshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 
 * @author pavanpulla
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WorkShopSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.headers()
		     .frameOptions().disable()
		.and()
		.csrf()
		     .disable()
		
		.authorizeRequests()
		    .antMatchers("/h2-*").hasRole("ADMIN")
		    .antMatchers(HttpMethod.GET, "/api/registrations").hasRole("ADMIN")
		    .antMatchers(HttpMethod.GET, "/css/*", "/js/*", "/images/*", "/webfonts/*", "/view/*").permitAll()
		    .anyRequest().permitAll()
		.and()
		.httpBasic();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails adminUser = User
				.builder()
				.username("pawan")
				.password(passwordEncoder.encode("pawan"))
				.authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
				.build();
		return new InMemoryUserDetailsManager(adminUser);
	}

}
