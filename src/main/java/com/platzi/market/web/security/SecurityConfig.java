package com.platzi.market.web.security;

import com.platzi.market.domain.service.MarketUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity // Class to charge the Security
public class SecurityConfig {

    private MarketUserDetailsService marketUserDetailsService;

    @Autowired
    public SecurityConfig(MarketUserDetailsService marketUserDetailsService) {
        this.marketUserDetailsService = marketUserDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, AuthenticationManagerBuilder auth) throws Exception {
        auth = http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(marketUserDetailsService).and();
        return auth.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable().authorizeHttpRequests().antMatchers("/**/authenticate").permitAll().anyRequest().authenticated().and().build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//
//    }




}
