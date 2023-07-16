package com.example.webdemo.config;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.result.R;
import net.dreamlu.mica.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl UserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //某些接口不进行拦截
                .antMatchers("/*/query").permitAll()
                // 任何路径下的请求需要经过身份验证
                .anyRequest().authenticated();


        http.formLogin()
                //认证成功处理器
                .successHandler((request, response, authentication) -> {
                    log.info("认证成功");
                    String redirect = request.getParameter("redirect");
                    if (StringUtil.isNoneBlank(redirect)) {
                        log.info(redirect);
                        response.sendRedirect(redirect);
                    } else {
                        response.setContentType("application/json;charset=UTF-8");
                        response.setStatus(HttpServletResponse.SC_OK);
                        response.getWriter().write(JSONUtil.toJsonStr(R.success("认证成功")));
                    }
                })

                //认证失败处理器
                .failureHandler((request, response, exception) -> {
                    log.info("密码错误，请重新输入");
                    response.setContentType("application/json;charset=UTF-8");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write(JSONUtil.toJsonStr(R.success("密码错误，请重新输入。")));
                })
                //登录放行
                .permitAll();


        //异常访问权限的处理器
        http.exceptionHandling()
                .accessDeniedHandler((httpServletRequest, response, e) -> {
                    log.info("没有权限");
                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    log.info(JSONUtil.toJsonStr(authentication));
                    response.setContentType("application/json;charset=UTF-8");
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.getWriter().write(JSONUtil.toJsonStr(R.success("没有权限")));
                });

        //退出成功处理器
        http.logout()
                .logoutSuccessHandler((httpServletRequest, response, authentication) -> {
                    log.info("退出成功");
                    response.setContentType("application/json;charset=UTF-8");
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.getWriter().write(JSONUtil.toJsonStr(R.success("退出成功")));
                })
                //退出放行
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(UserDetailService).passwordEncoder(passwordEncoder());

//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder().encode("111"))
//                .roles("admin");  //转变为 ROLE_admin权限
//
//        auth.inMemoryAuthentication()
//                // 定义用户名
//                .withUser("student")
//                // 将今天的日期加密后作为密码进行存储
//                .password(passwordEncoder().encode("111"))
//                .authorities("student:query", "student:add", "student:update");
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(passwordEncoder().encode("111"))
//                .authorities("user:query");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
