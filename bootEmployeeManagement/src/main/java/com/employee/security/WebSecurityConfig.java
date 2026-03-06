package com.employee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
//	private final PasswordEncoder passwordEncoder;
	
	private final JwtAuthFilter jwtAuthFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		
		httpSecurity
				.csrf(csrfConfig -> csrfConfig.disable())
				.sessionManagement(sessionConfig -> 
					sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/public/**","/auth/**").permitAll()
//	  					    .requestMatchers("/admin/**").hasRole("ADMIN")
						        .anyRequest().authenticated()
				)
				.addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class);
//				.formLogin(Customizer.withDefaults());

		return httpSecurity.build();
		
	}
	
//	@Bean
//	UserDetailsService userDetailsService() {
//		UserDetails user1 = User.withUsername("admin")
//										.password("pass")
//										.roles("ADMIN")
//										.build();
//		
//		UserDetails user2 = User.withUsername("employee")
//				.password("pass")
//				.roles("EMPLOYEE")
//				.build();
//
//		
//		return new InMemoryUserDetailsManager();
		
//	}

}
