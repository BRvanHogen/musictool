package com.backend.eindopdracht.musictool.config;

import com.backend.eindopdracht.musictool.filter.JwtRequestFilter;
import com.backend.eindopdracht.musictool.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //het volgende is eigenlijk 1 statement. Elke conditie wordt 1 voor 1 gecheckt.
        http
//onderstaande antPatterns kan je chainen!!
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/customers/**").hasRole("USER")
                .antMatchers("/projects/**").hasRole("USER")
                .antMatchers("/projects/**").hasRole("ADMIN")
                .antMatchers("/comments/**").hasRole("ADMIN")
                .antMatchers("/comments/**").hasRole("USER")
                .antMatchers("/comments/**").hasRole("ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/users/get-users/**").hasRole("ADMIN")
                .antMatchers("/users/sign-up/**").permitAll()
                .antMatchers("/authenticated/**").authenticated()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/{username}/authorities").hasRole("ADMIN")
                //---------------------------------------
                //even voor test:
                .antMatchers("/projects/**").permitAll()
                .antMatchers("/comments/**").permitAll()
                .antMatchers("/soundfiles/**").permitAll()
                .antMatchers("/upload-file/**").permitAll()
                .antMatchers("/upload/**").permitAll()
                .antMatchers("/files/**").permitAll()
                .antMatchers("/files/player/**").permitAll()
                .antMatchers("/tasks/**").permitAll()
                //--------------------------
                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type", "X-Requested-With", "XMLHttpRequest"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/users/**", configuration);
        source.registerCorsConfiguration("/authenticate/**", configuration);
        source.registerCorsConfiguration("/projects/**", configuration);
        source.registerCorsConfiguration("/comments/**", configuration);
        source.registerCorsConfiguration("/upload/**", configuration);
        source.registerCorsConfiguration("/files/**", configuration);
        source.registerCorsConfiguration("/files/player/**", configuration);
        source.registerCorsConfiguration("/tasks/**", configuration);
        return source;
    }
}
