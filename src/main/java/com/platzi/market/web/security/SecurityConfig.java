package com.platzi.market.web.security;

import com.platzi.market.domain.service.MarketUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity // Class to charge the Security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private MarketUserDetailsService marketUserDetailsService;

    @Autowired
    public SecurityConfig(MarketUserDetailsService marketUserDetailsService) {
        this.marketUserDetailsService = marketUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(marketUserDetailsService);
    }
}
