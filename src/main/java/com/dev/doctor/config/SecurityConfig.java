package com.dev.doctor.config;




import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableConfigurationProperties
public class SecurityConfig extends WebSecurityConfigurerAdapter {



  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .httpBasic()
      .and()
      .authorizeRequests()
      .antMatchers("/h2-console/**").permitAll()
      .antMatchers("/").permitAll().antMatchers("/doctors").permitAll()
  
      .and()
      .csrf().disable()
      .headers().frameOptions().disable();
  }



}
