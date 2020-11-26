package com.simbirsoft.springcourse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService securityUser;

    @Override
    protected UserDetailsService userDetailsService(){
        return securityUser;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf().disable()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }



    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
