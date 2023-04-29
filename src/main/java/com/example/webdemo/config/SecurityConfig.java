//package com.example.webdemo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.util.DigestUtils;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//@SuppressWarnings("all")
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/api/**").authenticated() // 定义/api/**路径下的请求需要经过身份验证
//                .and()
//                .httpBasic()
//                .and()
//                .logout()
//                .logoutUrl("/logout")//表示用户注销时需要访问的URL是/logout。
//                .clearAuthentication(true) // 清除身份验证信息
//                .logoutSuccessUrl("/admin")//表示用户成功注销后要重定向到的页面是/admin
//                .invalidateHttpSession(true)//表示在注销时是否同时使HttpSession失效，默认为true。
//                .deleteCookies("JSESSIONID")//表示在注销时将删除名为JSESSIONID的cookie。
//                .permitAll()//表示任何用户都可以访问/logout端点，即使用户未登录也可以注销。
//                .and()
//                .csrf().disable()//禁用CSRF保护使得应用程序可以接受POST、PUT、DELETE等类型的请求，而不需要在请求中包含CSRF令牌。
//                .formLogin().disable();//禁用了基于表单的身份认证，并使用.httpBasic()方法启用了HTTP Basic认证。
//
//    }
//
//
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        String encryptedPassword = DigestUtils.md5DigestAsHex(currentDate.getBytes());
//        auth.inMemoryAuthentication()
//                .withUser("test")
//                .password(passwordEncoder().encode("123456"))
//                .roles("USER");
//
//
//    }
//
//}
