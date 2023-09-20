package com.example.swagger292.config;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfig{

    @Bean
    PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder(); 
    }

    // @Autowired
    // LoginIdPwValidator loginIdPwValidator;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf 
                        .disable()
                )
                .authorizeRequests(requests -> requests
                        .antMatchers("**").permitAll()    // LoadBalancer Chk
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/loginProc")
                        .usernameParameter("userid")
                        .passwordParameter("userpw")
                        .defaultSuccessUrl("/", true)
                        .permitAll())
                .logout( logout -> { logout
                    .addLogoutHandler((request, response, authentication) -> { 
                            HttpSession session = request.getSession();
                            if (session != null) {
                                    session.invalidate();
                            }
                    })  // 로그아웃 핸들러 추가
                    .logoutSuccessHandler((request, response, authentication) -> {
                            response.sendRedirect("/");
                    }) // 로그아웃 성공 핸들러
                    .deleteCookies("remember-me"); // 로그아웃 후 삭제할 쿠키 지정
                    });

        return http.build();    
    };

    // @Override
    // public void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.userDetailsService(loginIdPwValidator);
    // }
    
}