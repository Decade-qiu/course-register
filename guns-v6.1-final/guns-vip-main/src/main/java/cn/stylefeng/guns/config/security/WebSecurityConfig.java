package cn.stylefeng.guns.config.security;

import cn.stylefeng.guns.sys.core.auth.entrypoint.JwtAuthenticationEntryPoint;
import cn.stylefeng.guns.sys.core.auth.filter.JwtAuthorizationTokenFilter;
import cn.stylefeng.guns.sys.core.auth.filter.NoneAuthedResources;
import cn.stylefeng.guns.sys.core.auth.userdetail.JwtUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * spring security配置
 *
 * @author fengshuonan
 * @Date 2019/7/20 17:55
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;

    @Autowired
    private JwtAuthorizationTokenFilter authenticationTokenFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        //csrf关闭
        httpSecurity.csrf().disable();

        //开启跨域
        httpSecurity.cors();

        //自定义退出
        httpSecurity.logout().disable();

        //禁用匿名用户
        //httpSecurity.anonymous().disable();

        httpSecurity.exceptionHandling().authenticationEntryPoint(unauthorizedHandler);

        // 全局不创建session
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //放开一些接口的权限校验
        for (String notAuthedResource : NoneAuthedResources.BACKEND_RESOURCES) {
            httpSecurity.authorizeRequests().antMatchers(notAuthedResource).permitAll();
        }

        //其他接口都需要权限
        httpSecurity.authorizeRequests().anyRequest().authenticated();

        //添加自定义的过滤器
        httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //disable page caching
        httpSecurity
                .headers()
                .frameOptions().sameOrigin()
                .cacheControl();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(
                        HttpMethod.POST,
                        "/login"
                )

                // 静态资源放开过滤
                .and()
                .ignoring()
                .antMatchers(
                        HttpMethod.GET,
                        "/assets/**",
                        "/favicon.ico",
                        "/activiti-editor/**"
                );

    }
}
