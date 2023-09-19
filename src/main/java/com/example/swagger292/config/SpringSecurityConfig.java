package com.example.swagger292.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.swagger292.security.LoginIdPwValidator;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
    LoginIdPwValidator loginIdPwValidator;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                        .antMatchers("/","/signup").permitAll()    // LoadBalancer Chk
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/fail")
                    .loginProcessingUrl("/loginProc")
                    .usernameParameter("userid")
                    .passwordParameter("userpw")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logoutProc"));
    };

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginIdPwValidator);
    }
    
}