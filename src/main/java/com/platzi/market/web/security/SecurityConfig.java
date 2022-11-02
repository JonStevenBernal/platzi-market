package com.platzi.market.web.security;

import com.platzi.market.domain.service.MarketUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity // Class to charge the Security
public class SecurityConfig {
//public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private MarketUserDetailsService marketUserDetailsService;

    @Autowired
    public SecurityConfig(MarketUserDetailsService marketUserDetailsService) {
        this.marketUserDetailsService = marketUserDetailsService;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(marketUserDetailsService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // All request that ending with authenticated are permit if not have this pattern needs authenticated
//        http.csrf().disable().authorizeHttpRequests().antMatchers("/**/authenticate").permitAll()
//                .anyRequest().authenticated();
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }



    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, AuthenticationManagerBuilder auth) throws Exception {
        auth = http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(marketUserDetailsService).and();
        return auth.build();
//        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
//        auth.userDetailsService(marketUserDetailsService).and().build();
//        return auth.build();
//            return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(marketUserDetailsService).and().build();
        return http.csrf().disable().authorizeHttpRequests().antMatchers("/**/authenticate").permitAll().anyRequest().authenticated().and().build();
    }
//    @Bean
//    public AuthenticationManager authenticationManagerConfig(HttpSecurity http) throws Exception {
//
//    }

//    @Bean
//    public SecurityFilterChain authManager(HttpSecurity http)  throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(marketUserDetailsService)
//                .and()
//                .build();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//
//    }

//    @Bean
//    public void authenticationManagerConfig(HttpSecurity http)  throws Exception {
//        // all request that ending in aunthenticated are permit
//        http.csrf().disable().authorizeHttpRequests().antMatchers("/**/authenticate").permitAll()
//                .anyRequest().authenticated();
//    }

//    @Bean
//    public AuthenticationManager authenticationManagerBean()  throws Exception {
//        return authenticationManagerBean();
//    }



}
