package com.company.AnnaNicholsU1Capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username = ?"
                )
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username = ?"
                )
                .passwordEncoder(encoder);

    }

    public void configure(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.httpBasic();

        httpSecurity
                .authorizeRequests()
                .mvcMatchers(HttpMethod.PUT, "/console", "/game", "/tshirt", "/invoice").hasAnyAuthority("STAFF_MEMBER", "MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.POST, "/console", "/game", "/tshirt", "/invoice").hasAnyAuthority("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/console/*", "/game/*", "/tshirt/*", "/invoice/*").hasAuthority("ADMIN")
                .anyRequest().permitAll()
        .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
        .and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }

}
