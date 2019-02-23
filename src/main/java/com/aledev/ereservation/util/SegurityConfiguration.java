/**
 * 
 */
package com.aledev.ereservation.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase para manejar la configuracion
 * @author CAVS5692
 *
 */
@Configuration
@EnableWebSecurity
public class SegurityConfiguration extends WebSecurityConfigurerAdapter{
	
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests().anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/app/login").permitAll()
				.failureUrl("/app/login?error=true")
				.defaultSuccessUrl("/app/home", true);
	}
	
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.authorizeRequests()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin().loginPage("/app/login").permitAll()
//			.failureUrl("/app/login?error=true")
//			.defaultSuccessUrl("/app/home", true);
//		//.and()
//		//.httpBasic();
//	}
	
	/**
	 * método de autentificación, para lo cual utilizamos un método en memoria
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("avillaseca").password(encoder.encode("Pass.1234")).roles("USER");
	}
	/**
	 * qué rutas de la aplicación se deben excluir del proceso de login, en la cual están todos los recursos estáticos configurados anteriormente
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}
