package com.spring.config;

import com.spring.filter.AuthenticationTokenFilter;
import com.spring.filter.TokenValidationFilter;
import com.spring.handler.CustomAccessDeniedHandler;
import com.spring.handler.CustomAuthenticationFailureHandler;
import com.spring.handler.CustomAuthenticationSuccessHandler;
import com.spring.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.DelegatingFilterProxy;

@EnableWebSecurity
public class UserDetailsConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public CustomUserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        http.authorizeRequests().
                antMatchers("/login", "/register","/accessDenied", "/", "/loginFailed").permitAll().anyRequest().authenticated().
                and().formLogin().disable().exceptionHandling().accessDeniedHandler(accessDeniedHandler());
        http.csrf().disable();
        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(tokenValidationFilter, AuthenticationTokenFilter.class);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
       // return new BCryptPasswordEncoder();

    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean(name = "authenticationTokenFilter")
    public AuthenticationTokenFilter authenticationTokenFilter() throws Exception {
        AuthenticationTokenFilter filter = new AuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
        filter.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler());
        filter.setAuthenticationFailureHandler(new CustomAuthenticationFailureHandler());
        return filter;

    }
    @Autowired
    TokenValidationFilter tokenValidationFilter;


}
