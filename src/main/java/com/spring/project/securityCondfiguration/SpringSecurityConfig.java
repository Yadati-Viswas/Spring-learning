package com.spring.project.securityCondfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain httpAuthenticator(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(
//                auth -> auth.anyRequest().authenticated()
//        );
//        http.httpBasic(Customizer.withDefaults());
        //http.csrf().disable();
        return http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic(withDefaults())
                .csrf().disable()
                .build();
    }
}
