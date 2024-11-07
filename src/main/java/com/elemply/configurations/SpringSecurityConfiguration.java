package com.elemply.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfiguration {
    private final CustomAuthProvider authProvider;

    @Autowired
    public SpringSecurityConfiguration(CustomAuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests ->
                requests.requestMatchers("/css/**", "/js/**", "/images/**", "/**")
                        .permitAll().anyRequest().authenticated()).formLogin(
                                login -> login.loginProcessingUrl("/authorization")
                                        .defaultSuccessUrl("/", true)
                ).authenticationProvider(authProvider)
                .logout(logout ->
                        logout.logoutUrl("/authorization/logout")
                                .logoutSuccessUrl("/").permitAll())
                .build();
    }
}
