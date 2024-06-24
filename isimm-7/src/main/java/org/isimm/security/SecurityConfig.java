package org.isimm.security;

import javax.sql.DataSource;

import org.isimm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource datasource;
	//// @Autowired
	//   private UserService userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		PasswordEncoder passwordEncoder=passwordEncoder();
		//auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("1234")).roles("USER");
		//auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1234")).roles("USER");
		//auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("USER","ADMIN");
		
		 auth.jdbcAuthentication()
	        .dataSource(datasource)
	        .usersByUsernameQuery("select username as principal ,password as credentials ,cin from account where username=?")
	        .authoritiesByUsernameQuery("select username as principal ,user_role as role from role where username=?")
	        .passwordEncoder(passwordEncoder);
	       		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
	//http.formLogin();
		http
        .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/login") // Handle POST requests to /login
            .defaultSuccessUrl("/home") // Redirect to this URL after successful login
            .permitAll();
		http.authorizeRequests().antMatchers("/students**/**","/searchStudent**/**","/deleteStudent**/**","/addStudent**/**"
				,"/saveStudent**/**","/editStudent**/**","/infoStudent**/**","/admin**/**","/register**/**","/accounts**/**",
				"/deleteAccount**/**","/editAccount**/**","/addmarks**/**","/ajoutnotes**/**","/inginfo1**/**","/inginfo1notes**/**",
				"/addemploi**/**","/ajoutemploiinginfo1**/**","/notifications**/**","/addActualites**/**","/ajoutActualites**/**","/deleteActualite**/**"
				,"/editActualite**/**").hasRole("ADMIN");	
		http.authorizeRequests().antMatchers("/etudiant**/**","/profile**/**","/mesnotes**/**","/emploidetemps**/**","/actualites**/**").hasRole("STUDENT");	
	//	http.authorizeRequests().anyRequest().authenticated();//delete this line when adding accueil
		http
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login")
        .permitAll();
	   
	    http.exceptionHandling().accessDeniedPage("/notAuthorized");
	   
	}
	/*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
            .passwordEncoder(passwordEncoder());
    }*/
	@Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
