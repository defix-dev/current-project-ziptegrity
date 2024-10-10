package com.elemply.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(requests ->
                requests.requestMatchers("/authorization/**", "/home", "/css/**", "/js/**", "/images/**")
                        .permitAll().anyRequest().authenticated())
                .formLogin(login ->
                        login.loginPage("/authorization")
                                .defaultSuccessUrl("/home")
                                .usernameParameter("username")
                                .passwordParameter("password").permitAll())
                .logout(logout ->
                        logout.logoutUrl("/authorization/logout")
                                .logoutSuccessUrl("/authorization").permitAll())
                .build();
    }
}
