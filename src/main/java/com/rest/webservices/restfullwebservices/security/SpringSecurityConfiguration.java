package com.rest.webservices.restfullwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        //all request should be authorized
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        //crea un popup para autenticar.
        http.httpBasic(Customizer.withDefaults());

        //csrf - post, put.
        http.csrf().disable();

        return http.build();

    }
}
