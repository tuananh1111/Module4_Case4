package com.casestudy.case4.config;

import com.casestudy.case4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IUserService IUserService;

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void globalSecurityConfig(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(IUserService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/login", "/createNewUser").permitAll()
        .antMatchers("/user/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//        .antMatchers("/host").access("hasRole('ROLE_HOST') or hasRole('ROLE_ADMIN')")
        .and().formLogin().successHandler(customSuccessHandler)
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .and().exceptionHandling().accessDeniedPage("/accessDenied");
    }
}
