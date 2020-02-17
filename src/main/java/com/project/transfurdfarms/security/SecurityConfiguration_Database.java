package com.project.transfurdfarms.security;

import com.project.transfurdfarms.services.UserInfoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration_Database extends WebSecurityConfigurerAdapter {

    @Autowired
    UserInfoDetailsService userInfoDetailsService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception{

        authenticationManagerBuilder
                .userDetailsService(userInfoDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{





        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/register/")
                .permitAll()
                .antMatchers("/crops/api/")
                .authenticated()
                .and()
                .formLogin()
                .and()

                .httpBasic()
        ;





    }




}
