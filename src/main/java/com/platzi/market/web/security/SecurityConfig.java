package com.platzi.market.web.security;

import com.platzi.market.domain.service.MarketUserDetailsService;
import com.platzi.market.web.security.filter.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity // Class to charge the Security
public class SecurityConfig {

    private MarketUserDetailsService marketUserDetailsService;

    private JwtFilterRequest jwtFilterRequest;

    @Autowired
    public SecurityConfig(MarketUserDetailsService marketUserDetailsService, JwtFilterRequest jwtFilterRequest) {
        this.marketUserDetailsService = marketUserDetailsService;
        this.jwtFilterRequest = jwtFilterRequest;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, AuthenticationManagerBuilder auth) throws Exception {
        auth = http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(marketUserDetailsService).and();
        return auth.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests()
                .antMatchers("/**/authenticate", "/v3/api-docs/**","/swagger-ui.html", "/swagger-ui/**")
                .permitAll().anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class).build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//
//    }




}
