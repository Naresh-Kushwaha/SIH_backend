package com.example.SIH1613.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class securityConfig {
    @Autowired
    private AdminDetailsServiceImpl adminDetailsService;

    @Autowired
    private StudentDetailsServiceImpl studentDetailsService;

    @Autowired
    private facultyDetailsServiceImpl facultyDetailsService;

    @Bean
    public UserDetailsService adminDetailsService(){
        return adminDetailsService;
    }
   @Bean
    public UserDetailsService studentDetailsService(){
        return studentDetailsService;
    }
    @Bean
    public UserDetailsService facultyDetailsService(){
        return facultyDetailsService;
    }
    @Bean
     public SecurityFilterChain AsecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/admin/create","/api/admin/login","/api/student/login","/api/student/create","/api/faculty/create","/api/faculty/login","/api/publications","api/googlepublications").permitAll()
                        .anyRequest().authenticated())

                .httpBasic(withDefaults())
                .formLogin(withDefaults());


        http.authenticationProvider(AauthenticationProvider());
        http.authenticationProvider(SauthenticationProvider());
        http.authenticationProvider(FauthenticationProvider());

        return http.build();

    }


    @Bean
    public AuthenticationProvider AauthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(adminDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;

    }
    @Bean
    public AuthenticationProvider SauthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(studentDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;

    }
    @Bean
    public AuthenticationProvider FauthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(facultyDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;

    }
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }




}
