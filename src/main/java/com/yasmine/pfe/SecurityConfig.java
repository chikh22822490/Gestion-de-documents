package com.yasmine.pfe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{
    
    @Bean
    protected SecurityFilterChain configuer(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }
}
