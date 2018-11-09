package com.sanjay.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author Sanjay
 *	
 * @EnableWebSecurity - marker annotation to make add manual security config
 * @Configuraiton - we use both the annotations to switch-of default security login
 * We can customize the security by extending class WebSecurityConfigurerAdapter
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			.antMatchers("/user").hasAnyRole("USER","ADMIN") // USER,ADMIN role can access /user/ 
			.antMatchers("/admin").hasRole("ADMIN") // ADMIN role can access /admin/
			.antMatchers("/role").permitAll() // anyone can access /role/
			.anyRequest().authenticated() // any-other request just need authentication
			.and()
			.formLogin(); // enable form login
		http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser("sai")
			.password(encoder.encode("sai"))
			.roles("USER")
			.and()
			.withUser("admin")
			.password(encoder.encode("admin"))
			.roles("ADMIN");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring()
			.antMatchers("/resources/**");
	}
	
}