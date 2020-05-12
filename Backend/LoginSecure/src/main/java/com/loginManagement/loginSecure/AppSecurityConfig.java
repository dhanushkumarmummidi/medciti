 package com.loginManagement.loginSecure;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.loginManagement.loginSecure.filters.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtRequestFilter JwtRequestFilter;
	@Bean
	public AuthenticationProvider authProvide() 
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
		
	}
		@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
			
		
		http 
				.csrf().disable()
//				.authorizeRequests().antMatchers("/authenticate").permitAll()
//				.anyRequest().authenticated()
//				.and()
//				.authorizeRequests().antMatchers("/login").permitAll()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//				.loginPage("/login").permitAll()
//				.and()
				
				.authorizeRequests().antMatchers("/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(JwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
				
//				.and()
//				.logout().invalidateHttpSession(true)
//				.clearAuthentication(true)
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/logout-success").permitAll();
	}
		 @Bean
		    public CorsConfigurationSource corsConfigurationSource() {
		        CorsConfiguration configuration = new CorsConfiguration();
		        configuration.setAllowedOrigins(Arrays.asList("*"));
		        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
		        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
		        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		        source.registerCorsConfiguration("/**", configuration);
		        return source;
		    }
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * List<UserDetails> users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("ravi").password("1234")
	 * .roles("USER").build());
	 * users.add(User.withDefaultPasswordEncoder().username("prudvi").password(
	 * "ravi").roles("USER").build());
	 * 
	 * return new InMemoryUserDetailsManager(users); }
	 */
}
